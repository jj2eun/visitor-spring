package com.kitri.visitor.dao;

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorDao {
	// 글 작성
	public int visitorRegist(VisitorVO vo); 
	// 글 목록
	public List<VisitorVO> visitorList();
	// 글 수정
	public int visitorUpdate(VisitorVO vo);
	// 글 삭제
	public int visitorDelete(int vNo, String vPwd);
	// 비밀번호 확인
	public int visitorPasswordCheck(VisitorVO vo);
}
