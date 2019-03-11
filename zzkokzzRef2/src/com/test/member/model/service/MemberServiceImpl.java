package com.test.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.test.member.model.MemberDetailDto;
import com.test.member.model.MemberDto;
import com.test.member.model.ZipDto;
import com.test.member.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int idCheck(String id) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.idCheck(id);
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.zipSearch(dong);
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.register(memberDetailDto);
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.login(map);
	}

}

















