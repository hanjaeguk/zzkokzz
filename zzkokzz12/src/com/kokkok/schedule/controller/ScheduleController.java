package com.kokkok.schedule.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kokkok.dto.ScheduleReviewDto;
import com.kokkok.dto.ScheduleReviewDtoList;
import com.kokkok.dto.ScheduleViewDto;
import com.kokkok.schedule.service.ScheduleService;

@Controller
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	
	
	@RequestMapping(value="/schedule/list.kok",method=RequestMethod.GET)
	public String scheduleList() {
		return "schedule/list";
	}
	
	@RequestMapping(value="/schedule/write.kok",method=RequestMethod.GET)
	public String scheduleWrite() {
		return "schedule/write";
	}
	
	@RequestMapping(value="/schedule/write.kok",method=RequestMethod.POST)
	public String scheduleWrite(@RequestParam Map<String,Object> map, HttpSession session, RedirectAttributes redirect,
			ScheduleReviewDtoList list) {
		//MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		//map.put("userid", memberDto.getUserid());
		map.put("userid", "sseul");		
		// schedule insert
		// +) file upload
		int scheduleCnt = scheduleService.scheduleWrite(map);
		int reviewCnt = 0;
		
		
		// review insert
		for(int i =0; i<list.getList().size() ; i++) {			
			Map<String, Object> reviewMap = new HashMap<>();
			
			reviewMap.put("userid", "sseul"); //id setting!!!!!!!!!!!!!!!!!!!!!!!
			
			reviewMap.put("bcode", list.getList().get(i).getBcode());
			reviewMap.put("subject", list.getList().get(i).getSubject());
			reviewMap.put("content", list.getList().get(i).getContent());
			reviewMap.put("location", list.getList().get(i).getLocation());
			reviewMap.put("lat", list.getList().get(i).getLat());
			reviewMap.put("lng", list.getList().get(i).getLng());
			reviewMap.put("address", list.getList().get(i).getAddress());
			reviewMap.put("simpleaddr", list.getList().get(i).getSimpleaddr());
			reviewMap.put("tripday", list.getList().get(i).getTripday());
			reviewMap.put("step", list.getList().get(i).getStep());
			
			reviewCnt = scheduleService.scheduleReviewWrite(reviewMap);
		}
		String path = "";
		if(scheduleCnt!=0 && reviewCnt!=0) {
			// 湲�踰덊샇 媛��졇媛�湲� 肄붾뵫�빐�빞�븿
			String sseq = scheduleService.selectSseq();
			ScheduleViewDto scheduleViewDto = scheduleService.scheduleView(sseq);
			List<ScheduleReviewDto> scheduleReviewDtoList = scheduleService.scheduleReviewView(sseq);
			
			if(scheduleViewDto != null) {
				scheduleViewDto.setContent(scheduleViewDto.getContent().replaceAll("\n", "<br>"));
				scheduleViewDto.setStartdate(scheduleViewDto.getStartdate().substring(0,11));
				scheduleViewDto.setEnddate(scheduleViewDto.getEnddate().substring(0,11));
				scheduleViewDto.setLogtime(scheduleViewDto.getLogtime().substring(0,11));
				scheduleViewDto.setUpdatetime(scheduleViewDto.getUpdatetime().substring(0,11));
			}
			
			redirect.addAttribute("sseq", sseq);
			
			path = "redirect:/schedule/view.kok";
		}else {
			System.out.println("�씪�젙 �벐湲� �떎�뙣");
			path = "redirect:/schedule/list.kok";
		}		
		return path;
		/* 由щ럭 �벑濡앺븯�떎 �떎�뙣�떆 �뒪耳�以� �벑濡� rollback �빐�빞�븿 */
	}
	
	@RequestMapping(value="/schedule/view.kok",method=RequestMethod.GET)
	public ModelAndView scheduleView(@RequestParam String sseq) {
		ScheduleViewDto scheduleViewDto = scheduleService.scheduleView(sseq);
		List<ScheduleReviewDto> scheduleReviewDtoList = scheduleService.scheduleReviewView(sseq);
		
		if(scheduleViewDto != null) {
			scheduleViewDto.setContent(scheduleViewDto.getContent().replaceAll("\n", "<br>"));
			scheduleViewDto.setStartdate(scheduleViewDto.getStartdate().substring(0,11));
			scheduleViewDto.setEnddate(scheduleViewDto.getEnddate().substring(0,11));
			scheduleViewDto.setLogtime(scheduleViewDto.getLogtime().substring(0,11));
			scheduleViewDto.setUpdatetime(scheduleViewDto.getUpdatetime().substring(0,11));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("scheduleArticle",scheduleViewDto);
		mav.addObject("reviewArticle",scheduleReviewDtoList);
		mav.setViewName("schedule/view");		
		return mav;
	}
}
