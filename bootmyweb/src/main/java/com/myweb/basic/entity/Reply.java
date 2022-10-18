package com.myweb.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="REPLY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "notice") //notice필드는 투스트링제외
public class Reply extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno; //pk
	@Column(length = 50)
	private String writer; //작성자
	@Column(length = 500)
	private String text; //내용
	
	//매니투원의 기본조인방식은 eager조인 입니다. 
	//(모든 연관테이블 다 붙이는 형식이기때문에 성능하향의 이슈가 있습니다)
	//Lazy조인을 기본형식으로 사용하고, @Transactional어노테이션을 반드시 붙입니다
//	@ManyToOne(fetch = FetchType.LAZY) //연관관계에서 N쪽 테이블에 FK가 들어가게 됩니다 (다대일 단방향)
//	private Notice notice;
	
	//상대테이블의 원투매니
//	private Long notice_nno;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Notice notice;
	
	
	
	
	
	
	/*
	Hibernate: 
    
    alter table reply 
       add column notice_nno bigint
	Hibernate: 
    
    alter table reply 
       add constraint FKgfqu7ek9k7did3gvqy7hpab2e 
       foreign key (notice_nno) 
       references notice (nno)
	*/
}
