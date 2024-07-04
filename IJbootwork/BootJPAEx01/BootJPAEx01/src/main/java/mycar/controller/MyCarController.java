package mycar.controller;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarDto;
import mycar.repository.MyCarDao;
import naver.storage.NcpObjectStorageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class MyCarController {
    private final MyCarDao dao;
    private final NcpObjectStorageService storageService;
    private final MyCarDao myCarDao;
    String BucketName = "mycar";
    String FolderName = "MyCarPhotos";

    @GetMapping("/")
    public String home() {
        return "redirect:./mycar/mycarlist";
    }

//    @GetMapping("/mycar/mycarlist")
//    public String mycarlist(Model model) {
//        List<MyCarDto> list = dao.getAllCars();
//        model.addAttribute("list", list);
//        model.addAttribute("count", list.size());
//        return "mycar/mycarlist";
//    }

    @GetMapping("/mycar/mycarform")
    public String mycarform() {
        return "mycar/mycarform";
    }

    @PostMapping("/mycar/insert")
    public String insertCar(@ModelAttribute MyCarDto dto,
                            @RequestParam("carupload") MultipartFile carupload) {
        String filename = storageService.uploadFile(BucketName, FolderName, carupload);
        dto.setCarphoto(filename);
        dao.insertCar(dto);

        return "redirect:./mycarlist";
    }

    @GetMapping("/mycar/mycardetail")
    public String mycarDetail(@RequestParam("num") Long num,
                              Model model) {
        MyCarDto dto = dao.getCarById(num);
        model.addAttribute("dto", dto);

        return "mycar/mycardetail";
    }

    @GetMapping("/mycar/carupdate")
    public String mycarUpdate(@RequestParam("num") Long num,
                              Model model) {
        MyCarDto dto = dao.getCarById(num);
        model.addAttribute("dto", dto);

        return "mycar/mycarupdateform";
    }

    @PostMapping("/mycar/mycarupdate")
    public String mycarUpdateSuccess(@ModelAttribute MyCarDto dto,
                                     @RequestParam("carupload") MultipartFile carupload) {
        if (carupload.isEmpty()) {
            dto.setCarphoto("no");
        } else {
            //사진 수정을 하기 전 storage의 기존 사진을 지우자
            String oldPhotoname = dao.getCarById(dto.getNum()).getCarphoto();
            storageService.deleteFile(BucketName, FolderName, oldPhotoname);

            String photo = storageService.uploadFile(BucketName, FolderName, carupload);
            dto.setCarphoto(photo);
        }
        //수정 메소드 호출
        dao.updateCar(dto);
        return "redirect:/mycar/mycardetail?num=" + dto.getNum();
    }

    @GetMapping("/mycar/delete")
    public String mycarDelete(@RequestParam("num") Long num) {
        String photo = dao.getCarById(num).getCarphoto();
        storageService.deleteFile(BucketName, FolderName, photo);

        dao.deleteMyCar(num);

        return "redirect:/mycar/mycarlist";
    }

    //페이지네이션 해보기
    @GetMapping("/mycar/mycarlist")
    public String mycarlist(Model model,
                            @RequestParam(value = "page", defaultValue = "0") int page,
                            @RequestParam(value = "pageSize",defaultValue = "3") int pageSize) {
        //more가 0이면 기본 3개만 출력을 하고 0이 아니면 기본 사이즈에 more 값을 추가해서 목록을 가져옴

        if(page>0) {
            pageSize+=page;
        }

        //페이징을 위한 Pageable 클래스 처리
        Pageable pageable = PageRequest.of(0, pageSize, Sort.by("num").ascending());
        //페이지에 필요한만큼 가져오기
        Page<MyCarDto> result = myCarDao.getAllCars(pageable);

        model.addAttribute("total", result.getTotalElements());//총 dto 개수
        model.addAttribute("totalPages", result.getTotalPages());//토탈 / pageSize
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("list", result.getContent());

        return "mycar/mycarlist";
    }
}
