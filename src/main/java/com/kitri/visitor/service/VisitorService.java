package com.kitri.visitor.service;

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorService {
	// 글 작성
	public int visitorRegist(VisitorVO vo); 
	// 글 목록
	public List<VisitorVO> visitorList();
	// 글 수정
	public String visitorUpdate(VisitorVO vo);
	// 글 삭제
	public String visitorDelete(int vNo, String vPwd);
}
