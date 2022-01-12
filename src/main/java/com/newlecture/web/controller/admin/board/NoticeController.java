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



@Controller("adminNoticeController") //Xml�̵� javaConfig���� �̸� �浹�� ���� �ٸ��̸����� ������ �� �ִ�. 
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
//		if(request.getMethod().equals("POST")) { GET�̶� POST�� ������ ����� �ϳ�
		for(MultipartFile file : files) {
			
			long size = file.getSize();
			String fileName = file.getOriginalFilename();
			System.out.printf("fileName: %s, fileSize:%d\n",fileName, size);
			
			ctx = request.getServletContext();
			//root��� ���� webapp���� �����ؾߵ� ��θ� ���´�.
			String webPath = "/static/upload";
			//Servlet Context�� �����Ͽ� �����θ� ã�´�.
			String realPath = ctx.getRealPath(webPath);
			
			//���Ƿ� File�� �ϳ� ���� realPath�� �����Ͽ� �����.
			File savePath = new File(realPath);
			//���� savePath.exists() <-- boolean���� ���ִ� �Լ�
			//���ϰ�ΰ� ������ true, ������ false�̱� ������ ������ true�� �ǰڲ� �ٲ������.
				if(!savePath.exists())
					savePath.mkdirs(); //������ ����� �۾�(realPath�� ����)
				// savePath.mkdir�� �� ������ ������ �������ִµ� mkdirs�� ��ο��� ���� �͵��� �� ������ش�.
				//realPath �� fileName�� ��ġ�� �۾� //separator�� �ü���� ���� �ٸ��� ������ 
				//�ڵ����� �������ִ� File.separator�� ����Ѵ�.
			realPath += File.separator + fileName;
			System.out.printf("realPath : %s\n", realPath);
			//realPath�� ���� saveFile�� �����Ѵ�.
			File saveFile = new File(realPath); //���ο� ��ο� saveFile�� �ϳ� �����
			
			file.transferTo(saveFile); //�� ���Ͽ� ���޹��� ������ ��������.
		
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
