package com.kokkok.member.dao;

import java.util.List;
import java.util.Map;

import com.kokkok.member.dto.MemberDto;

public interface MemberDao {
	public int idCheck(String id);
	
	public int memberInsert(MemberDto memberDto);
	public MemberDto login(Map<String, String> hmap); 
	
	
	MemberDto getMember(String id);
	int modify(MemberDto memberDto); 
	int delete(String id); 
	
	
	
	List<MemberDto> memberList(Map<String,String> map);
}
