package com.newlecture.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@RestController("apiNoticeController") //묵시적으로 지정할 수 있음.
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public Notice list(@RequestParam(name="p", defaultValue = "1") Integer page) throws ClassNotFoundException, SQLException {
		
		List<Notice> list = service.getList(page, "title", "");
		
		return list.get(0);
	} //NoticeController noticeController = new NoticeController
		//<bean id="noticeController" class="...NoticeController/>
	
	@RequestMapping("detail")
	public String detail() {
		
		return "notice.detail";
	}
	
}
