package controller.board;

import data.dto.ReBoardDto;
import data.service.MemberService;
import data.service.ReBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/board")
public class BoardWriteController {
    @Autowired
    private ReBoardService reBoardService;
    @Autowired
    private MemberService   memberService;

    @GetMapping("/writeform")
    public String writeForm(
            //@RequestParam(required = false) String title, null값을 받아도 괜찮다는 뜻
            //답글이 아니고 새글일때는 다 null값이 넘어와서 새글일 경우의 defaultValue를 줌
            //답글일 때는 value들이 있음
            @RequestParam(defaultValue = "0") int num,
            @RequestParam(defaultValue = "0") int regroup,
            @RequestParam(defaultValue = "0") int restep,
            @RequestParam(defaultValue = "0") int relevel,
            @RequestParam(defaultValue = "1") int currentPage,
            Model model
    ) {
        //답글일 경우 원글의 제목을 얻어서 model에 저장해서 던진다.
        String subject = "";
        if (num>0) {
            subject = reBoardService.getData(num).getSubject();
        }

        model.addAttribute("subject", subject);
        model.addAttribute("regroup", regroup);
        model.addAttribute("restep", restep);
        model.addAttribute("relevel", relevel);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("num", num);

        return "board/writeform";
    }

    @PostMapping("/insert")
    public String insert(
            @ModelAttribute ReBoardDto dto,
            @RequestParam("upload") MultipartFile upload,
            @RequestParam int currentPage,
            HttpServletRequest request,
            HttpSession session
            ){
        String savePath=request.getSession().getServletContext().getRealPath("/save");
        //업로드 하지 않았을 경우 "no", 업로드 했을 경우 랜덤파일명으로 저장
        String photo = upload.getOriginalFilename();
        if(photo.equals("")){
            photo="no";
        }else{
            String ext = photo.substring(photo.lastIndexOf("."));
            photo = UUID.randomUUID()+"."+ext;
            try {
                upload.transferTo(new File(savePath+"/"+photo));
            } catch (IOException|IllegalStateException e) {
                throw new RuntimeException(e);
            }
        }
        dto.setUploadphoto(photo);
        //세션으로 부터 아이디 얻기
        String loginid=(String)session.getAttribute("loginid");
        dto.setMyid(loginid);
        //memberdb로 부터 아이디에 해당하는 이름을 얻어서 dto에 저장
        String writer=memberService.getMemberById(loginid).getName();
        dto.setWriter(writer);
        //확인할거... 추가후 저장된 시퀀스 값
        //지금 넣는 num이 출력됨
        System.out.println("num="+dto.getNum());
        reBoardService.insertBoard(dto);


        return "redirect:./list?currentPage="+currentPage;
    }
}
