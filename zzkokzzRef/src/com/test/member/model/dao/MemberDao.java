package com.test.member.model.dao;

import java.util.List;
import java.util.Map;

import com.test.member.model.MemberDetailDto;
import com.test.member.model.MemberDto;
import com.test.member.model.ZipDto;

public interface MemberDao {

	int idCheck(String id);
	List<ZipDto> zipSearch(String dong);
	int register(MemberDetailDto memberDetailDto);
	
	MemberDto login(Map<String, String> map);
	
}
