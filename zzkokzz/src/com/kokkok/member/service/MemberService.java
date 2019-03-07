package com.kokkok.member.service;


import org.springframework.web.servlet.ModelAndView;

import com.kokkok.member.dto.MemberDto;

public interface MemberService {
	public void mvRegister(ModelAndView mav);
	public void idCheck(ModelAndView mav);
	public void registerOk(ModelAndView mav);
	public void myInfo(ModelAndView mav);
	public void myWriteSchedule(ModelAndView mav);
	public void myWishSchedule(ModelAndView mav);
	public void myWishreview(ModelAndView mav);
	
    public MemberDto login(MemberDto memberDto);




	
}
