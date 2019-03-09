package com.kokkok.member.dao;

import java.util.List;
import java.util.Map;

import com.kokkok.dto.MemberDto;



public interface MemberDao {
	int register(MemberDto memberDto);
	int idCheck(String id);

	MemberDto login(Map<String, String> map);

	
	MemberDto getMember(String id);
	int modify(MemberDto memberDto); 
	int delete(String id); 
	
	
	// MemberDto login(String id,String pass); 
	
	List<MemberDto> memberList(Map<String,String> map);
}
