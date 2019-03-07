package com.kokkok.member.dao;


import com.kokkok.member.dto.MemberDto;

public interface MemberDao {

	public int memberInsert(MemberDto memberDto);

	public MemberDto login(MemberDto memberDto);

	public int idCheck(String id);


}
