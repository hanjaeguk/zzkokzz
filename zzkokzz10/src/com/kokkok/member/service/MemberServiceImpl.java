package com.kokkok.member.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.kokkok.dto.MemberDto;
import com.kokkok.dto.ReviewDto;
import com.kokkok.dto.ScheduleListDto;
import com.kokkok.member.dao.MemberDao;
import com.kokkok.schedule.dao.ScheduleListDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
 	private SqlSessionTemplate sqlSessionTemplate;
	
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
	public MemberDto login(Map<String, String> map) {
		MemberDao memberDao = sqlSessionTemplate.getMapper(MemberDao.class);
		return memberDao.login(map);
	}

	@Override
	public int register(MemberDto memberDto) {
		MemberDao memberDao = sqlSessionTemplate.getMapper(MemberDao.class);
		return memberDao.register(memberDto);
	}

	@Override
	public int idCheck(String id) {
		MemberDao memberDao = sqlSessionTemplate.getMapper(MemberDao.class);
		return memberDao.idCheck(id);
	}

	@Override
	public MemberDto findPw(Map<String, String> map) {
		MemberDao memberDao = sqlSessionTemplate.getMapper(MemberDao.class);
		return memberDao.findPw(map);
	}

	@Override
	public int updatePw(MemberDto memberDto) {
		MemberDao memberDao = sqlSessionTemplate.getMapper(MemberDao.class);
		return memberDao.updatePw(memberDto);
	}

	@Override
	public int memberModify(Map<String, String> map) {
		MemberDao memberDao = sqlSessionTemplate.getMapper(MemberDao.class);
		return memberDao.memberModify(map);
	}

	@Override
	public MemberDto reLogin(Map<String, String> map) {
		MemberDao memberDao = sqlSessionTemplate.getMapper(MemberDao.class);
		return memberDao.reLogin(map);
	}

	@Override
	public int memberdelete(Map<String, String> map) {
		MemberDao memberDao = sqlSessionTemplate.getMapper(MemberDao.class);
		return memberDao.memberdelete(map);
	}

	@Override
	public String getMyWishReview(int pg, int listNumOfRows, String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		int totCount = sqlSessionTemplate.selectOne("getMyWishReviewTotalCount", map);

		int startNum = listNumOfRows * pg - (listNumOfRows - 1);
		int endNum = listNumOfRows * pg;
		
		map.put("startNum", startNum + "");
		map.put("endNum", endNum + "");
		
		List<ReviewDto> list = sqlSessionTemplate.getMapper(MemberDao.class).getMyWishReview(map);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray();
		for(ReviewDto ReviewDto : list) {
			JSONObject myReviewList = new JSONObject();
			myReviewList.put("seq", ReviewDto.getSeq());
			myReviewList.put("bcode", ReviewDto.getBcode());
			myReviewList.put("userid", ReviewDto.getUserid());
			myReviewList.put("subject", ReviewDto.getSubject());
			myReviewList.put("content", ReviewDto.getContent());
			myReviewList.put("logtime", ReviewDto.getLogtime());
			myReviewList.put("updatetime", ReviewDto.getUpdatetime());
			myReviewList.put("recommcount", ReviewDto.getRecommcount());
			myReviewList.put("wishcount", ReviewDto.getWishcount());
			myReviewList.put("hit", ReviewDto.getHit());
			myReviewList.put("cname", ReviewDto.getCname());
			myReviewList.put("ccode", ReviewDto.getCcode());
			myReviewList.put("bname", ReviewDto.getBname());
			myReviewList.put("tseq", ReviewDto.getTseq());
			myReviewList.put("tname", ReviewDto.getTname());
			myReviewList.put("tcontent", ReviewDto.getTcontent());
			jarray.add(myReviewList);

		}
		json.put("totCount", totCount);
		
		json.put("myReviewList", jarray);
		return json.toString();
	}



}
