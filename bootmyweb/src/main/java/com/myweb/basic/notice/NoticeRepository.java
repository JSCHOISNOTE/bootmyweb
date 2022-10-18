package com.myweb.basic.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.myweb.basic.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>,  
										  QuerydslPredicateExecutor<Notice> { //엔티티, PK타입

	//쿼리메서드
	Page<Notice> findByWriter(String writer, Pageable pageable );
	
	//JPQL
	@Query("select n from Notice n where n.writer = :writer")
	Page<Notice> getListMe(@Param("writer") String writer, Pageable pageable);
	
	
	
	
	
	
	
	
	
	
	
	
}
