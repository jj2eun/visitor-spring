package com.kitri.visitor.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kitri.visitor.vo.VisitorVO;

@Repository
public class VisitorImpl implements VisitorDao{
	
	@Inject
	SqlSessionTemplate sqlSession;
	
	@Override
	public int visitorRegist(VisitorVO vo) {
		
		return sqlSession.insert("visitor.visitorRegist",vo);
	}

	@Override
	public List<VisitorVO> visitorList() {

		return sqlSession.selectList("visitor.visitorList");
	}

	@Override
	public int visitorUpdate(VisitorVO vo) {
		// TODO Auto-generated method stub
		System.out.println("vo: "+vo);
		return sqlSession.update("visitor.visitorUpdate", vo);
	}

	@Override
	public int visitorDelete(int vNo, String vPwd) {
		// 매게변수가 여러개있을 경우, map이나 vo객체에 담는다
		return sqlSession.delete("visitor.visitorDelete", vNo);
	}

	@Override
	public int visitorPasswordCheck(VisitorVO vo) {
		
		return sqlSession.selectOne("visitor.visitorPasswordCheck", vo);
	}
}

