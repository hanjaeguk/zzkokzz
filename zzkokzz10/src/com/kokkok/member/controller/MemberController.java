package com.kokkok.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.kokkok.comm.LogCheck;
import com.kokkok.dto.MemberDto;
import com.kokkok.dto.ReviewDto;
import com.kokkok.member.service.MemberService;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/member/register.kok",method=RequestMethod.GET)
	public String register() {
		return "member/join/register";
	}
	
	@RequestMapping(value="/member/register.kok",method=RequestMethod.POST)
	public ModelAndView register(MemberDto memberDto) {
		int cnt = memberService.register(memberDto);
		String path = "member/join/registerfail";
		ModelAndView mav = new ModelAndView();
		if(cnt != 0) {
			mav.addObject("memberInfo", memberDto);
			LogCheck.logger.info(LogCheck.logMsg + memberDto.toString());
			path = "redirect:/member/registerok.kok";
		}
		mav.setViewName(path);
		return mav;
	}
	
	@RequestMapping(value="/member/registerok.kok",method=RequestMethod.GET)
	public String registerOk() {
		return "member/join/registerok";
	}
	
	@RequestMapping(value="/member/idcheck.kok",method=RequestMethod.GET)
	public String idCheck() {
		return "member/join/idcheck";
	}
	
	@RequestMapping(value="/member/idsearch.kok",method=RequestMethod.POST)
	public ModelAndView idCheck(@RequestParam("checkid") String id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int cnt = memberService.idCheck(id);
		request.setAttribute("checkid", id);
		request.setAttribute("idCnt", cnt);
		mav.addObject("checkid", id);
		mav.addObject("idcnt", cnt);
		mav.setViewName("member/join/idcheck");
		return mav;
	}
	
	@RequestMapping(value="/member/myInfo.kok",method=RequestMethod.GET)
	public String myInfo() {
		return "member/myMenu/myInfo/view";
	}
	
	@RequestMapping(value="/member/modify.kok",method=RequestMethod.GET)
	public String memberModify() {
		return "member/myMenu/myInfo/modify";
	}
	
	@RequestMapping(value="/member/modify.kok",method=RequestMethod.POST)
	public ModelAndView memberModify(@RequestParam Map<String, String> map,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int check = memberService.memberModify(map);
		LogCheck.logger.info(LogCheck.logMsg + check);
		if(check != 0) {
			MemberDto memberDto = memberService.reLogin(map);
			session.setAttribute("userInfo", memberDto);
			LogCheck.logger.info(LogCheck.logMsg + memberDto.toString());
			mav.setViewName("member/myMenu/myInfo/modifyok");
		} else {
			mav.setViewName("member/myMenu/myInfo/modifyfail");			
		}
		return mav;
	}
	
	@RequestMapping(value="/member/delete.kok",method=RequestMethod.GET)
	public String memberDelete() {
		return "member/myMenu/myInfo/delete";
	}
	
	@RequestMapping(value="/member/delete.kok",method=RequestMethod.POST)
	public ModelAndView memberDelete(@RequestParam Map<String, String> map,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int check = memberService.memberdelete(map);
		LogCheck.logger.info(LogCheck.logMsg + check);
		if(check != 0) {
			session.invalidate();
			mav.setViewName("member/myMenu/myInfo/deleteok");
		} else {
			mav.setViewName("member/myMenu/myInfo/deletefail");
		}
		return mav;
	}
	

	@RequestMapping(value="/login.kok",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> map,HttpSession session, HttpServletRequest request) throws IOException {
		ModelAndView mav = new ModelAndView();
		String path = request.getHeader("referer");
		String projectName = request.getContextPath(); 
		LogCheck.logger.info(LogCheck.logMsg +"�씠�쟾 �럹�씠吏�寃쎈줈:"+ path);
		LogCheck.logger.info(LogCheck.logMsg +"�봽濡쒖젥�듃 �씠由�:"+ projectName);
		LogCheck.logger.info(LogCheck.logMsg +"�봽濡쒖젥�듃 湲몄씠:"+projectName.length());
		MemberDto memberDto = memberService.login(map);
		if(memberDto != null) {
			LogCheck.logger.info(LogCheck.logMsg + memberDto.toString());
			session.setAttribute("userInfo", memberDto);
			path = path.substring(path.lastIndexOf(projectName) + projectName.length()+1, path.length());
			LogCheck.logger.info(LogCheck.logMsg +"�씠�룞�븷 寃쎈줈:"+ path);
			
			if("index.jsp".equals(path) || "member/register.kok".equals(path) || "member/registerok.kok".equals(path)) {
				mav.setViewName("redirect:index.jsp");
				return mav;
			}
		} else {
			mav.setViewName("member/login/loginfail");
			return mav;
		}
		
		mav.setViewName("redirect:"+path);
		return mav;
	}
	
	@RequestMapping(value="/logout.kok",method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		return "redirect:index.jsp";
	}

	@RequestMapping(value="/member/findpass.kok",method=RequestMethod.GET)
	public String findPass() {
		return "member/login/findpassword";
	}

	@RequestMapping(value="/member/findpass.kok",method=RequestMethod.POST)
	public ModelAndView findPass(@RequestParam Map<String, String> map) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = memberService.findPw(map);
		if(memberDto != null) {
			String pw = "";
			for (int i = 0; i < 8; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			memberDto.setUserpass(pw);
			memberService.updatePw(memberDto);
		    try {
		    	String htmlContent = "";
		    	htmlContent += memberDto.getUsername()+"�떂 諛섍컩�뒿�땲�떎.<br>";
		    	htmlContent += "�엫�떆鍮꾨�踰덊샇媛� 諛쒓툒�쇅�뿀�뒿�땲�떎.<br>";
		    	htmlContent += "<font style=\"font-size: 20px; \">�엫�떆鍮꾨�踰덊샇:</font>";
		    	htmlContent += "<font color=\"red\" style=\"font-size: 25px; font-weight: bold;\">"+memberDto.getUserpass().toString()+"</font><br>";
		    	htmlContent += "濡쒓렇�씤�썑 鍮꾨�踰덊샇瑜� 蹂�寃쏀빐二쇱꽭�슂.<br>";
		    	htmlContent += "媛먯궗�빀�땲�떎.";
			    MimeMessage message = mailSender.createMimeMessage();

			    message.setFrom(new InternetAddress("kokkokbangbang@gmail.com","Kokkok"));  // 蹂대궡�뒗�궗�엺 �씠硫붿씪
			    message.addRecipient(RecipientType.TO, new InternetAddress(memberDto.getUseremail())); // 諛쏅뒗�궗�엺 �씠硫붿씪
			    message.setSubject("諛⑸갑肄뺤퐬 �엫�떆鍮꾨�踰덊샇�엯�땲�떎."); // �젣紐�
			    message.setText(htmlContent, "UTF-8", "html");  // �궡�슜
			     
			    mailSender.send(message);
				mav.addObject("memberDto",memberDto);
			    mav.setViewName("member/login/sendmailok");
			    } catch(Exception e){
			      System.out.println(e);
			    }
		} else {
			mav.setViewName("member/login/sendmailfail");
		}
		return mav;

	}
	

	@RequestMapping(value="/admin/memberlist.kok",method=RequestMethod.GET)
	public String memberList() {
		return "admin/members/list";
	}
	
	
	@RequestMapping(value="/member/mywritelist.kok",method=RequestMethod.GET)
	public ModelAndView myWriteList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		memberService.myWriteSchedule(mav);
		return mav;
	}
	
	@RequestMapping(value="/member/mywishschedule.kok",method=RequestMethod.GET)
	public ModelAndView myScheduleWish(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		memberService.myWishSchedule(mav);
		return mav;
	}
	
	@RequestMapping(value="/member/mywishreview.kok",method=RequestMethod.GET)
	public  String myWishReview() {
		return "member/myMenu/myWish/myreviewlist";
	}
	
	@RequestMapping(value="/member/getmywishreview.kok", produces = "application/text; charset=utf8", method=RequestMethod.GET)	
	public @ResponseBody String getMyWishReview(@RequestParam(value="userid") String userid,
											  	@RequestParam(value="pg") int pg,	
											  	@RequestParam(value="listNumOfRows") int listNumOfRows) {	
		String myReviewDtoList = memberService.getMyWishReview(pg, listNumOfRows, userid);
		LogCheck.logger.info(LogCheck.logMsg +"myReviewDtoList"+ myReviewDtoList);
		LogCheck.logger.info(LogCheck.logMsg +"myReviewDtoList"+ listNumOfRows);
		return myReviewDtoList; 
	}
	

}
