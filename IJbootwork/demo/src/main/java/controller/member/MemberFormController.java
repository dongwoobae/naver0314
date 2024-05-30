package controller.member;

import data.dto.MemberDto;
import data.service.MemberService;
import naver.cloud.NcpObjectStorageService;
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

    //naver storage에 저장하기 위한 변수들
    private String bucketName="bitcamp-bucket-56";
    private String folderName="photocommon";
    @Autowired
    private NcpObjectStorageService storageService;

    @GetMapping("/form")
    public String form(){
        return "member/memberform";
    }
    @PostMapping("/insert")
    public String insert(@ModelAttribute MemberDto dto,
                         @RequestParam("myfile") MultipartFile myfile,
                         HttpServletRequest request){
//        String savePath = request.getSession().getServletContext().getRealPath("/save");
//        String ext = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf("."));
//        String photo= UUID.randomUUID()+"."+ext;
//        dto.setPhoto(photo);
//        try {
//            myfile.transferTo(new File(savePath+"/"+photo));
//        } catch (IOException|IllegalStateException e) {
//            throw new RuntimeException(e);
//        }
        //storage에 업로드하기
        String photo=storageService.uploadFile(bucketName, folderName, myfile);
        dto.setPhoto(photo);
        memberService.insertMember(dto);
        return "redirect:/member/list";
    }
    @ResponseBody //json으로 반환
    @GetMapping("/idcheck")
    public Map<String, Integer> getMethodName(@RequestParam String searchid) {
        Map<String, Integer> map = new HashMap<>();

        int count=memberService.getIdCheck(searchid);

        map.put("count", count);

        return map;
    }
}
