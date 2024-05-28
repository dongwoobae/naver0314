package controller.member;

import data.dto.MemberDto;
import data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/member")
public class MemberFormController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/form")
    public String form(){
        return "member/memberform";
    }
    @PostMapping("/insert")
    public String insert(@ModelAttribute MemberDto dto,
                         @RequestParam("myfile") MultipartFile myfile,
                         HttpServletRequest request){
        String savePath = request.getSession().getServletContext().getRealPath("/save");
        String ext = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf("."));
        String photo= UUID.randomUUID()+"."+ext;
        dto.setPhoto(photo);
        try {
            myfile.transferTo(new File(savePath+"/"+photo));
        } catch (IOException|IllegalStateException e) {
            throw new RuntimeException(e);
        }
        memberService.insertMember(dto);
        return "redirect:/member/list";
    }
}
