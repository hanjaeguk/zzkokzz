package com.test.admin.model.service;

import java.util.List;
import java.util.Map;

import com.test.member.model.MemberDetailDto;
import com.test.util.PageNavigator;

public interface AdminService {

	List<MemberDetailDto> memberList(Map<String, String> map);
	PageNavigator getPageNavigator(Map<String, String> map);	
	
}
