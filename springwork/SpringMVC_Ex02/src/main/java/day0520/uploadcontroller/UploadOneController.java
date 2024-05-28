package day0520.uploadcontroller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadOneController {
	@GetMapping("/uploadform1")
	public String upload1() {
		
		return "test/uploadform1";
	}

	@PostMapping("/upload1")
	public String uploadPhoto1(
			@RequestParam String title,
			@RequestParam ("upload") MultipartFile upload,
			HttpServletRequest request,
			Model model
			) {
		//톰캣 서버에 배포된 프로젝트에서 이미지가 업로드 될 경로 구하기
				String realFolder = request.getSession().getServletContext().getRealPath("/resources/upload");
				System.out.println(realFolder);

				//String fileName = upload.getOriginalFilename();

				//동시에 여러명이 서버에 접근해서 업로드할경우 
				//같은 파일명이 있을 수 있다. 그래서 랜덤파일명으로 업르도를 해보자
				//시분초를 뒤에 붙일 수도 있는데 여러장 업로드일 시 같아질 수도 있음
				String fileName=UUID.randomUUID()+".jpg";
				//위의 경로에 해당 파일명으로 업로드해보자
				try {
					upload.transferTo(new File(realFolder+"/"+fileName));
					model.addAttribute("title",title);
					model.addAttribute("photo",fileName);
				} catch (IllegalStateException |IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return "test/resultphoto1";
	}
}
