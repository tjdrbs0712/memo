package com.sparta.memo;

import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext // 스프링 부트에서 Entity 매니저를 받아오는 어노테이션
    EntityManager em;

    @Autowired //자동 의존성 주입(Bean에 저장되어 있는 해당 타입을 주입해줌)
    MemoRepository memoRepository;

    @Test
    @Transactional // 트랜잭셔널 어노테이션 덕분에 트랜잭션을 시작하고 종료할 필요가 없다.
    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
    @DisplayName("메모 생성 성공")
    void test1() {
        Memo memo = new Memo();
        memo.setUsername("Robbert");
        memo.setContents("@Transactional 테스트 중!");

        em.persist(memo);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }

    @Test
    @Disabled //이 테스트 메서드를 더 이상 사용하지 않겠다는 뜻으로 빨간색 표시를 사라지게 해줌
    @DisplayName("메모 생성 실패")
    void test2() {
        Memo memo = new Memo();
        memo.setUsername("Robbie");
        memo.setContents("@Transactional 테스트 중!");

        em.persist(memo);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }

    @Test
    @Transactional
    @Disabled
    @Rollback(value = false)
    @DisplayName("트랜잭션 전파 테스트")
    void test3() {
        //memoRepository.createMemo(em);
        System.out.println("테스트 test3 메서드 종료");
    }
}
