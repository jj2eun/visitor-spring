package com.kitri.visitor.service;

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorService {
	// �� �ۼ�
	public int visitorRegist(VisitorVO vo); 
	// �� ���
	public List<VisitorVO> visitorList();
	// �� ����
	public String visitorUpdate(VisitorVO vo);
	// �� ����
	public String visitorDelete(int vNo, String vPwd);
}
