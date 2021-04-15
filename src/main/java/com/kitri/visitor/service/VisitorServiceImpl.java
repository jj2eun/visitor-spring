package com.kitri.visitor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.visitor.dao.VisitorDao;
import com.kitri.visitor.vo.VisitorVO;

// VisitorController���� resource�� ���� DI �� �� �ְ� Bean��ü ���
@Service
public class VisitorServiceImpl implements VisitorService{

	// VisitorImpl ��ü
	@Autowired
	VisitorDao visitorDao;
	
	@Override
	public int visitorRegist(VisitorVO vo) {
		// TODO Auto-generated method stub
		return visitorDao.visitorRegist(vo);
	}

	@Override
	public List<VisitorVO> visitorList() {
		
		return visitorDao.visitorList();
	}

	@Override
	public String visitorUpdate(VisitorVO vo) {
		int vNo = visitorDao.visitorPasswordCheck(vo);
		String msg = null;
		
		// �۹�ȣ�� ��й�ȣ�� ��Ī�� �ȵǸ�,
		if (vNo == 0) {
			msg = "��й�ȣ ����";
		} else {
			// �۹�ȣ�� ��й�ȣ�� ��Ī�� �Ǹ�,
			int updateCheck = visitorDao.visitorUpdate(vo);
			System.out.println("updateCheck "+updateCheck );
			if(updateCheck == 0) msg = "���� ����"; // ���� ����
			else msg = "���� �Ϸ�"; // ���� �Ϸ�
		}
		
		return msg;
	}

	@Override
	public String visitorDelete(int vNo, String vPwd) {
		VisitorVO vo = new VisitorVO();
		vo.setvPwd(vPwd);
		vo.setvNo(vNo);
		int no = visitorDao.visitorPasswordCheck(vo);
		vo = null;
		
		String msg = null;
		// �۹�ȣ�� ��й�ȣ�� ��Ī�� �ȵǸ�,
		if (no == 0) {
			msg = "��й�ȣ ����";
		} else {
			// �۹�ȣ�� ��й�ȣ�� ��Ī�� �Ǹ�,
			//Map<String, String> map = new HashMap<String, String>();
			//map.put(vPwd, msg)
			int deleteCheck = visitorDao.visitorDelete(vNo, vPwd);
			if(deleteCheck == 0) msg = "���� ����"; // ���� ����
			else msg = "���� �Ϸ�"; // ���� �Ϸ�
		}
		return msg;
	}

}
