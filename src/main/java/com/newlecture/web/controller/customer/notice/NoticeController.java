package com.newlecture.web.controller.customer.notice;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@RequestMapping("/customer/notice/")
@Controller
public class NoticeController{
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("detail")
	public String detail() {
		
		return "notice.detail";
	}
	
	@RequestMapping("list")
	public String list(@RequestParam(value = "p", defaultValue = "1") int page) throws ClassNotFoundException, SQLException {
		System.out.println("page:"+page);
		List<Notice> list = noticeService.getList(1, "title", "");
		
		return "notice.list";
	}
	
	
	
	//@Override
	//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	
	//	ModelAndView mv = new ModelAndView("notice.detail");
//		mv.addObject("data", "Hello Spring Mvc~");
//		mv.setViewName("/notice/detail");
	//	return mv;
//	}
	
}
