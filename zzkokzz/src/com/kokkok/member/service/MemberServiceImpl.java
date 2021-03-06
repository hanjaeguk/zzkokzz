package com.kokkok.member.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.kokkok.comm.logcheck.CommAspect;
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
	public void idCheck(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		mav.setViewName("/member/join/idcheck");	
	}













}
