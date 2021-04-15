package com.kitri.visitor.dao;

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorDao {
	// �� �ۼ�
	public int visitorRegist(VisitorVO vo); 
	// �� ���
	public List<VisitorVO> visitorList();
	// �� ����
	public int visitorUpdate(VisitorVO vo);
	// �� ����
	public int visitorDelete(int vNo, String vPwd);
	// ��й�ȣ Ȯ��
	public int visitorPasswordCheck(VisitorVO vo);
}
