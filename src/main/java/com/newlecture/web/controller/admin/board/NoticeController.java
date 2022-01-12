package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller("adminNoticeController") //Xml이든 javaConfig에서 이름 충돌이 날때 다른이름으로 지정할 수 있다. 
@RequestMapping("/admin/board/notice/")
public class NoticeController { //<bean name="noticeController" class="......NoticeController"
	
	@Autowired
	ServletContext ctx;
	
	@RequestMapping("list")
	public String list(@RequestParam(value="p", defaultValue = "1")Integer page) {
		System.out.println("page:"+page);
		
		return "admin.board.notice.list";
	}
	
	/*
	 * @RequestMapping(value="reg"; method=RequestMethod.Get)
	 * 
	 * @RequestMapping(value="reg"; method=RequestMethod.POST)
	 */
	
	@GetMapping("reg")
	public String reg() {

		
		return "admin.board.notice.reg";
	}
	
	@PostMapping("reg")
	public String reg(String title, String content,MultipartFile[] files, String category, String[] foods, String food, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
//		if(request.getMethod().equals("POST")) { GET이랑 POST랑 나누는 방법중 하나
		for(MultipartFile file : files) {
			
			long size = file.getSize();
			String fileName = file.getOriginalFilename();
			System.out.printf("fileName: %s, fileSize:%d\n",fileName, size);
			
			ctx = request.getServletContext();
			//root경로 기준 webapp부터 저장해야될 경로를 적는다.
			String webPath = "/static/upload";
			//Servlet Context를 생성하여 절대경로를 찾는다.
			String realPath = ctx.getRealPath(webPath);
			
			//임의로 File을 하나 만들어서 realPath에 대입하여 만든다.
			File savePath = new File(realPath);
			//만약 savePath.exists() <-- boolean으로 되있는 함수
			//파일경로가 있으면 true, 없으면 false이기 때문에 없으면 true가 되겠끔 바꿔줘야함.
				if(!savePath.exists())
					savePath.mkdirs(); //폴더를 만드는 작업(realPath를 통해)
				// savePath.mkdir은 맨 마지막 폴더만 생성해주는데 mkdirs는 경로에서 없는 것들을 다 만들어준다.
				//realPath 와 fileName을 합치는 작업 //separator는 운영체제에 따라 다르기 때문에 
				//자동으로 생성해주는 File.separator를 사용한다.
			realPath += File.separator + fileName;
			System.out.printf("realPath : %s\n", realPath);
			//realPath를 통해 saveFile을 저장한다.
			File saveFile = new File(realPath); //새로운 경로에 saveFile을 하나 만들고
			
			file.transferTo(saveFile); //그 파일에 전달받은 파일을 생성해줌.
		
		}
		
		
		return "admin.board.notice.reg";
	}
	
	@RequestMapping("edit")
	public String edit() {
		return "admin.board.notice.edit";
	}
	
	@RequestMapping("delete")
	public String delete() {
		return "admin.board.notice.delete";
	}
}
