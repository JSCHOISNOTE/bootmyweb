package com.myweb.basic.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass //해당 어노테이션을 붙이면 테이블로 생성되지 않고 부모클래스로 사용
@EntityListeners(AuditingEntityListener.class) //JPA엔티티를 관리는 영속성영역에서 변화를 감지해서 자동으로 변수에 적용해주는 역할
@Getter
public class BaseEntity {
	//공통클래스
	@CreatedDate //생성시간
	@Column(name = "regdate", updatable = false)
	private LocalDateTime regdate;
	
	@LastModifiedDate //변경시간
	@Column(name = "moddate")
	private LocalDateTime moddate;
	
	//BootMywebApplication클래스에 @EnableJpaAuditing 를 추가해야합니다.
	
}
