package mycar.controller;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarDto;
import mycar.repository.MyCarDao;
import mycar.repository.MyCarDaoInter;
import naver.storage.NcpObjectStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyCarController {
    private final MyCarDao dao;
    private final NcpObjectStorageService storageService;
    String BucketName="mycar";
    String FolderName="MyCarPhotos";

    @GetMapping("/")
    public String home() {
        return "redirect:./mycar/mycarlist";
    }

    @GetMapping("/mycar/mycarlist")
    public String mycarlist(Model model) {
        List<MyCarDto> list= dao.getAllCars();
        model.addAttribute("list",list);
        model.addAttribute("count",list.size());
        return "mycar/mycarlist";
    }

    @GetMapping("/mycar/mycarform")
    public String mycarform() {
        return "mycar/mycarform";
    }

    @PostMapping("/mycar/insert")
    public String insertCar(@ModelAttribute MyCarDto dto,
                            @RequestParam("carupload") MultipartFile carupload) {
        String filename=storageService.uploadFile(BucketName,FolderName,carupload);
        dto.setCarphoto(filename);
        dao.insertCar(dto);

        return "redirect:./mycarlist";
    }
    @GetMapping("/mycar/mycardetail")
    public String mycarDetail(@RequestParam long num,
            Model model) {
        MyCarDto dto=dao.getCarById(num);
        model.addAttribute("dto",dto);

        return "mycar/mycardetail";
    }
}
