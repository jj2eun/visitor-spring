package com.kitri.visitor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.visitor.dao.VisitorDao;
import com.kitri.visitor.vo.VisitorVO;

// VisitorController에서 resource를 통해 DI 할 수 있게 Bean객체 등록
@Service
public class VisitorServiceImpl implements VisitorService{

	// VisitorImpl 객체
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
		
		// 글번호와 비밀번호가 매칭이 안되면,
		if (vNo == 0) {
			msg = "비밀번호 오류";
		} else {
			// 글번호와 비밀번호가 매칭이 되면,
			int updateCheck = visitorDao.visitorUpdate(vo);
			System.out.println("updateCheck "+updateCheck );
			if(updateCheck == 0) msg = "수정 실패"; // 수정 실패
			else msg = "수정 완료"; // 수정 완료
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
		// 글번호와 비밀번호가 매칭이 안되면,
		if (no == 0) {
			msg = "비밀번호 오류";
		} else {
			// 글번호와 비밀번호가 매칭이 되면,
			//Map<String, String> map = new HashMap<String, String>();
			//map.put(vPwd, msg)
			int deleteCheck = visitorDao.visitorDelete(vNo, vPwd);
			if(deleteCheck == 0) msg = "삭제 실패"; // 삭제 실패
			else msg = "삭제 완료"; // 삭제 완료
		}
		return msg;
	}

}
