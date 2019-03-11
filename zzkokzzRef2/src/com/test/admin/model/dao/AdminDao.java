package com.test.admin.model.dao;

import java.util.List;
import java.util.Map;

import com.test.member.model.MemberDetailDto;

public interface AdminDao {

	List<MemberDetailDto> memberList(Map<String, String> map);
	int totalArticleCount(Map<String, String> map);
	
}
