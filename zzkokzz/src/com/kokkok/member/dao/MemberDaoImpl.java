package com.kokkok.member.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kokkok.member.dto.MemberDto;

@Component
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;


	@Override
	public int memberInsert(MemberDto memberDto) {
		return sqlSessionTemplate.insert("memberInsert", memberDto);
	}






}
