package com.test.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.test.member.model.MemberDetailDto;
import com.test.member.model.MemberDto;
import com.test.member.model.ZipDto;
import com.test.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
@SessionAttributes(value="userInfo")
public class MemberController {
	
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/register.test",method=RequestMethod.GET)
	public String register() {
		return "join/member";
	}
	
	@RequestMapping(value="/register.test",method=RequestMethod.POST)
	public ModelAndView register(MemberDetailDto memberDetailDto) {
		int cnt = memberService.register(memberDetailDto);
		String path = "join/member_fail";
		ModelAndView mav = new ModelAndView();
		if(cnt != 0) {
			mav.addObject("memberInfo", memberDetailDto);
			path = "join/member_ok";
		}
			
		mav.setViewName(path);
		return mav;
	}
	
	@RequestMapping(value="/zipsearch.test",method=RequestMethod.GET)
	public String zipSearch() {
		return "join/zipsearch";
	}
	
	@RequestMapping(value="/zipsearch.test",method=RequestMethod.POST)
	public ModelAndView zipSearch(@RequestParam("dong") String dong) {
		List<ZipDto> list = memberService.zipSearch(dong);
		ModelAndView mav = new ModelAndView();
		mav.addObject("ziplist", list);
		mav.addObject("searchdong", dong);
		mav.setViewName("join/zipsearch");
		return mav;
	}
	
	@RequestMapping(value="/login.test",method=RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	
//	@RequestMapping(value="/login.test",method=RequestMethod.POST)
//	public String login(@RequestParam Map<String, String> map, ModelMap model) {
//		MemberDto memberDto = memberService.login(map);
//		String path = "login/login_fail";
//		if(memberDto != null) {
//			model.addAttribute("userInfo", memberDto);
//			path = "login/login_ok";
//		}
//		return path;
//	}
	
	@RequestMapping(value="/login.test",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> map) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = memberService.login(map);
		String path = "login/login_fail";
		if(memberDto != null) {
			mav.addObject("userInfo", memberDto);
			path = "login/login_ok";
		}
		mav.setViewName(path);
		return mav;
	}
	
	@RequestMapping("/idcheck.test")
	public @ResponseBody String idCheck(@RequestParam("sid") String id) {
		int idcount = memberService.idCheck(id);
		return idcount + "," + id;
	}
	
	@RequestMapping("/st.test")
	public String st() {
		return "sessiontest/st";
	}
	
	@RequestMapping("/logout.test")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "login/login";
	}
	
}


























