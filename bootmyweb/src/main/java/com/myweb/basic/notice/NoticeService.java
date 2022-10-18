package com.myweb.basic.notice;

import java.util.List;

import com.myweb.basic.entity.Notice;
import com.myweb.basic.util.Criteria;
import com.myweb.basic.util.PageDTO;

public interface NoticeService {

	Notice noticeReg(Notice notice);//등록
	PageDTO<Notice> getList(Criteria cri); //조회
	
	
	Notice getDetail(Long nno); //상세
	List<Notice> getListMe(String writer); //나의글조회
	void noticeUpdate(Notice notice); //나의글수정 
	void noticeDelete(Long nno); //삭제
	
	
}
