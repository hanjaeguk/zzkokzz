package com.test.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.admin.model.service.AdminService;
import com.test.member.model.MemberDetailDto;
import com.test.util.PageNavigator;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value="/memberlist.test",method=RequestMethod.GET)
	public String memberList() {
		return "admin/memberlist";
	}
	
	@RequestMapping(value="/memberlist.test",method=RequestMethod.POST,produces="application/json; charset=utf8")
	public @ResponseBody String memberList(@RequestParam Map<String, String> map, HttpServletRequest request) {
		List<MemberDetailDto> list = adminService.memberList(map);
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		for(MemberDetailDto mdto : list) {
			JSONObject job = new JSONObject();
			job.put("name", mdto.getName());
			job.put("id", mdto.getId());
			job.put("email", mdto.getEmail1() + "@" + mdto.getEmail2());
			job.put("tel", mdto.getTel1() + "-" + mdto.getTel2() + "-" + mdto.getTel3());
			job.put("address", mdto.getZip1() + "-" + mdto.getZip2() + " " + mdto.getAddress() + " " + mdto.getAddress_detail());
			job.put("joindate", mdto.getJoindate());
			
			jarr.add(job);
		}
		json.put("members", jarr);
		
		PageNavigator navigator = adminService.getPageNavigator(map);
		navigator.setRoot(request.getContextPath());
		navigator.makeNavigator();
		String navigation = navigator.getNavigator();
		json.put("navigator", navigation);
		System.out.println(json.toJSONString());
		return json.toJSONString();
	}
}













