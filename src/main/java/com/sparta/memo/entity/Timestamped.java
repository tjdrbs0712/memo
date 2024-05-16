package com.sparta.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//시간을 넣어주는 기능이 있는 어노테이션
public abstract class Timestamped {

    @CreatedDate //createdAt 변수에 시간값을 자동으로 저장
    @Column(updatable = false) // 업데이트 금지
    @Temporal(TemporalType.TIMESTAMP) // 자바의 DATE, TIME, TIMESTAMP를 맵핑해주는 기능 EX)2020-01-01
    private LocalDateTime createdAt;

    @LastModifiedDate // modifiedAt 변경된 시간을 넣어주는 어노테이션
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;
}