
package com.kokkok.member.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.guestAop.GuestAspect;
import com.kokkok.member.dao.MemberDao;
import com.kokkok.member.dto.MemberDto;

@Component
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void myInfo(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		mav.setViewName("/member/myMenu/myInfo/view");		
	}

	@Override
	public void myWriteSchedule(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		mav.setViewName("/member/myMenu/myWrite/list");		
	}

	@Override
	public void myWishSchedule(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		mav.setViewName("/member/myMenu/myWish/myschedulelist");		
	}

	@Override
	public void myWishreview(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		mav.setViewName("/member/myMenu/myWish/myreviewlist");		
	}

	@Override
	public void mvRegister(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		mav.setViewName("/member/join/register");		
	}

	@Override
	public void registerOk(ModelAndView mav) {
		
		Map<String, Object> map = mav.getModelMap();
		MemberDto memberDto=(MemberDto) map.get("memberDto");
		memberDto.setJoinDate(new Date());

		int check=memberDao.memberInsert(memberDto);

		mav.addObject("check",check);		
		mav.setViewName("/member/join/registerok");		
	}

	@Override
	public void mvidCheck(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		mav.setViewName("/member/join/idcheck");	
	}

	@Override
	public void login(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String id = (String)map.get("id");
		String pass = (String)map.get("pass");
		
		Map<String, String> hmap = new HashMap<>();
		map.put("id", id);
		map.put("pass", pass);
		
		MemberDto memberDto = null;
		
		memberDto = memberDao.login(hmap);
		mav.addObject("memberDto",memberDto);		


		if(memberDto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);
			mav.setViewName("/member/join/register");		
		}
		mav.setViewName("/member/myMenu/myWish/myreviewlist");
	}




}
