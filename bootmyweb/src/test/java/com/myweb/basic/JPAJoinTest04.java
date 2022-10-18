package com.myweb.basic;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myweb.basic.entity.Notice;
import com.myweb.basic.entity.Reply;
import com.myweb.basic.notice.NoticeRepository;
import com.myweb.basic.reply.ReplyRepository;

@SpringBootTest
public class JPAJoinTest04 {
	
	@Autowired
	NoticeRepository noticeRepository;
	
	@Autowired
	ReplyRepository replyRepository;
	
	
//	@Test
//	public void testCode01() {
//		
//		//reply의 더미데이터
//		for(int i =1 ; i <= 500; i++) {
//			//랜덤값
//			try {
//				long ran = (long)(Math.random() * 601) + 1; //1~601
//				//랜덤한 nno값을 가지고 있는 notice
//				Notice notice = Notice.builder().nno(ran).build();
//				
//				Reply reply = Reply.builder().writer("test" + i)
//											   .text("text" + i)
//											   .notice(notice)
//											   .build();
//				replyRepository.save(reply); //저장
//				
//			} catch (Exception e) {
//				System.out.println("참조컬럼없음");
//			}
//		}
//	}

	@Transactional
	@Test
	public void testCode02() {
		
		Optional<Reply> result= replyRepository.findById(100L);
		 if(result.isPresent()) {
			 Reply reply = result.get();
			 System.out.println(reply.toString());
		 }
		 
	}
	
	//원투매니
	@Transactional
	@Test
	public void testCode03() {
		
		Optional<Notice> result = noticeRepository.findById(7L);
		
		if(result.isPresent()) {
			Notice n = result.get();
			System.out.println(n.toString());
		}
		
	}
	
	
	
	
	
}
