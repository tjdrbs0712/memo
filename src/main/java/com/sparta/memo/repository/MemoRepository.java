package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //없어도 됨 SimpleJpaRepository.class가 이미 선언해줘서
public interface MemoRepository extends JpaRepository<Memo, Long> {


}
