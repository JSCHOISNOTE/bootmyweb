package com.myweb.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.myweb.basic.entity.Notice;
import com.myweb.basic.entity.QNotice;
import com.myweb.basic.notice.NoticeRepository;
import com.myweb.basic.util.Criteria;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@SpringBootTest
public class JPAQuerydslTest03 {

	@Autowired
	NoticeRepository noticeRepository;
	
//	@Test
//	public void testCode01() {
//		
//		//페이지 조회
//		Criteria cri = new Criteria(1, 10);
//		PageRequest pageable = PageRequest.of( cri.getPage()-1, 
//											   cri.getAmount(),
//											   Sort.by("nno").descending() );
//		
//		//쿼리DSQL Q클래스 사용
//		//빌드된 Q도메인클래스
//		QNotice qNotice = QNotice.notice;
//		
//		//불린빌더(where조건에 들어가는 조건을 넣는 객체)
//		BooleanBuilder booleanBuilder= new BooleanBuilder();
//		//조건을 표현
//		//BooleanExpression express = qNotice.writer.eq("admin");
//		//조건을 표현
//		BooleanExpression express = qNotice.writer.like("%2%");
//		//불린빌더에 and, or 이용해서 조건을 합침
//		booleanBuilder.and(express); 
//		
//		express = qNotice.content.like("%3%");
//		booleanBuilder.and(express);
//		
//		Page<Notice> result = noticeRepository.findAll(booleanBuilder , pageable);
//		
//		for(Notice n : result.getContent()) {
//			System.out.println(n.toString());
//		}
//	}
	
	
	@Test
	public void testCode02() {
		
		//페이지 조회
		//화면에서는 page, amount, 검색키워드를 넘긴다고 가정
		Criteria cri = new Criteria(1, 10);
		cri.setWriter("admin");
		//cri.setTitle("2");
		cri.setContent("3");
		
		PageRequest pageable = PageRequest.of( cri.getPage()-1, 
											   cri.getAmount(),
											   Sort.by("nno").descending() );
		
		//Q도메인클래스
		QNotice qNotice = QNotice.notice;
		//조건을 조합할 불린빌더
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		//동적쿼리
		if( cri.getWriter() != null && !cri.getWriter().equals("") ) {
			//불릭익스프레스 표현
			booleanBuilder.and( qNotice.writer.like("%" + cri.getWriter() + "%") );
		}
		
		if( cri.getTitle() != null && !cri.getTitle().equals("") ) {
			booleanBuilder.and( qNotice.title.like("%" + cri.getTitle() + "%") );
		}

		if( cri.getContent() != null && !cri.getContent().equals("") ) {
			booleanBuilder.and( qNotice.content.like("%" + cri.getContent() + "%"));
		}
		//sql실행
		Page<Notice> result = noticeRepository.findAll(booleanBuilder, pageable);
		
		for(Notice n : result.getContent() ) {
			System.out.println(n.toString());
		}
		
		
	}
	
	
	
	
	
	
	
	
}
