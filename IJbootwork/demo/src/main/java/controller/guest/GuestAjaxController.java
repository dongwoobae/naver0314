package controller.guest;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import data.service.GuestService;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import naver.cloud.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/guest")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GuestAjaxController {
    @NonNull
    private GuestService guestService;
    @NonNull
    private MemberService memberService;
    @NonNull
    private NcpObjectStorageService storageService;

    private String bucketName = "bitcamp-bucket-56";
    private String folderName = "guestphoto";

    @PostMapping("/addGuest")
    public void guestInsert(
            @RequestParam("gcontent") String gcontent,
            //required=false 를 안주면 null 값 들어오면 400번 오류남
            @RequestParam(value = "upload",required = false) List<MultipartFile> upload,
            HttpSession session
            ){
        //세션에서 로그인 되있는 아이디 얻기
        String myid =(String)session.getAttribute("loginid");
        //아이디를 얻어서 해당 아이디의 이름 얻기
        String writer = memberService.getMemberById(myid).getName();
        //dto에 데이터 넣기
        GuestDto dto = GuestDto.builder().
                writer(writer).
                myid(myid).
                gcontent(gcontent).build();
        guestService.insertGuest(dto);//이때 guestidx로 추가된 시퀀스값이 selectkey로 들어옴
        int guestidx = dto.getGuestidx();
        //파일을 클라우드 스토리지에 업로드
        //파일을 업로드하지 않은경우
        //파일에서 직접호출하는 경우
//        if(upload.get(0).getOriginalFilename().equals("")){
//            return;
//        }
        //지금은 등록버튼 누를때 파일이 전달되는 방식
        //파일을 아예 안눌렀으면 null이 됨
        if(upload==null || upload.isEmpty()){
            return;
        }
        for(MultipartFile mfile : upload) {
            //스토리지에 저장후 파일명 얻기
            String photoname = storageService.uploadFile(bucketName, folderName, mfile);
            //db에 인서트
            GuestPhotoDto dto1 = new GuestPhotoDto();
            dto1.setGuestidx(guestidx);
            dto1.setPhotoname(photoname);

            guestService.insertGuestPhoto(dto1);

        }
    }
    @PostMapping("/datas")
    public List<GuestDto> guestlist(){
        List<GuestDto> list = guestService.selectAllGuest();
        return list;
    }
}
