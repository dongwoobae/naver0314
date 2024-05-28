package controller.member;

import data.dto.MemberDto;
import data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class MemberUpdateController {
    @Autowired
    private MemberService memberService;

    @ResponseBody
    @PostMapping("/updatephoto")
    public Map<String,String> uploadPhoto(
            @RequestParam int num,
            @RequestParam("upload") MultipartFile myfile,
            HttpServletRequest request
    ){
        Map<String,String> map = new HashMap<>();
        String savePath = request.getSession().getServletContext().getRealPath("/save");
        String ext = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf("."));
        String photo= UUID.randomUUID()+"."+ext;

        try {
            myfile.transferTo(new File(savePath+"/"+photo));
        } catch (IOException|IllegalStateException e) {
            throw new RuntimeException(e);
        }

        map.put("photo",photo);
        memberService.updatePhoto(photo,num);
        return map;
    }
    @ResponseBody
    @GetMapping("/delete")
    public Map<String,String> deleteMember(
            @RequestParam String passwd,
            @RequestParam int num
    ){
        Map<String,String> map = new HashMap<>();
        int success = memberService.deleteMember(num,passwd);
        if(success==1){
            map.put("status","success");
        }else {
            map.put("status","fail");
        }
        return map;
    }
    @PostMapping("/updateform")
    public String updateForm(@RequestParam int num,
                             Model model){
        MemberDto dto = memberService.getMemberByNum(num);
        model.addAttribute("dto",dto);
        return "member/updateform";
    }
    @PostMapping("/update")
    public String updateMember(
            @ModelAttribute MemberDto dto,
            @RequestParam int num
    ){
        memberService.updateMember(dto);
        return "redirect:/member/detail?num="+num;
    }
}
