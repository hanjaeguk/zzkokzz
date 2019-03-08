package com.test.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.test.admin.model.dao.AdminDao;
import com.test.member.model.MemberDetailDto;
import com.test.util.Constance;
import com.test.util.PageNavigator;

@Service
public class AdminServiceImpl implements AdminService {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MemberDetailDto> memberList(Map<String, String> map) {
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		int pg = Integer.parseInt(map.get("pg"));
		int end = pg * Constance.MEMBER_LIST_SIZE;
		int start = end - Constance.MEMBER_LIST_SIZE;
		System.out.println(start + "               " + end);
		map.put("start", start + "");
		map.put("end", end + "");
		return adminDao.memberList(map);
	}

	@Override
	public PageNavigator getPageNavigator(Map<String, String> map) {
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		int pg = Integer.parseInt(map.get("pg"));
		PageNavigator navigator = new PageNavigator();		
		navigator.setNowFirst(pg <= Constance.MEMBER_PAGE_SIZE);
		navigator.setPageNo(pg);
		int totalArticleCount = adminDao.totalArticleCount(map);
		navigator.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / Constance.MEMBER_LIST_SIZE + 1;
		navigator.setTotalPageCount(totalPageCount);
		navigator.setNowEnd((totalPageCount - 1) / Constance.MEMBER_PAGE_SIZE * Constance.MEMBER_PAGE_SIZE < pg);
		return navigator;
	}

}








