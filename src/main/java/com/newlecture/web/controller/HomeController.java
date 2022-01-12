package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/")
@Controller
public class HomeController {
	
	@RequestMapping("index")
	@ResponseBody
	public String index() {
		
		return "Hello Index1";
	}
	
	//@ResponseBody 는 HttpServletResponse response 
	//PrintWriter out;
	//out.println("hello world"); 와 똑같다
	//Front Controller Servlet Service 객체임.
	//문서 출력 방법 4가지
	//서블릿 객체를 얻어서 문자열 출력하기
	//@ResponseBody 설정을 통한 문자열 출력하기
	//ResourceViewResolver 를 이용한 문서 출력하기
	//TilesViewResolver를 이용한 문서 출력하기
	
	
	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * // System.out.println("index controller");
	 * 
	 * ModelAndView mv = new ModelAndView("root.index"); mv.addObject("data",
	 * "Hello Spring Mvc~"); //mv.setViewName("/WEB-INF/view/index.jsp"); return mv;
	 * }
	 */
	
}
