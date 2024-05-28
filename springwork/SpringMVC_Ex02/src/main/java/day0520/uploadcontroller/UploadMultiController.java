package day0520.uploadcontroller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadMultiController {
	@GetMapping("/uploadform2")
	public String upload2() {

		return "test/uploadform2";
	}

	@PostMapping("/upload2")
	public String uploadResult(
			@RequestParam String title,
			@RequestParam("upload") List<MultipartFile> upload,
			HttpServletRequest request,
			Model model
			) {
		//��Ĺ ������ ������ ������Ʈ���� �̹����� ���ε� �� ��� ���ϱ�
		String realFolder = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realFolder);

		//�� ���� ������ �𵨿� �����ص���
		int len = upload.size();
		model.addAttribute("len", len);
		model.addAttribute("title",title);
		
		//�������� ������ ������ ���ε��غ���
		//����Ǵ� ������ photo1,photo2,... ��
		//���ε�� ���ϸ� ���ϱ�
		String photo=UUID.randomUUID()+"";
		model.addAttribute("photo",photo);
		int n=1;
		for(MultipartFile multi:upload) {
			try {
				multi.transferTo(new File(realFolder+"/"+photo+n+".jpg"));				
				n++;
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "test/resultphoto2";
	}
}
