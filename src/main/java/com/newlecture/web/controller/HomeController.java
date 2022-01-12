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
	
	//@ResponseBody �� HttpServletResponse response 
	//PrintWriter out;
	//out.println("hello world"); �� �Ȱ���
	//Front Controller Servlet Service ��ü��.
	//���� ��� ��� 4����
	//���� ��ü�� �� ���ڿ� ����ϱ�
	//@ResponseBody ������ ���� ���ڿ� ����ϱ�
	//ResourceViewResolver �� �̿��� ���� ����ϱ�
	//TilesViewResolver�� �̿��� ���� ����ϱ�
	
	
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
