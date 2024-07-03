package mycar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MyCarController {

    @GetMapping("/")
    public String home() {
        return "redirect:./mycar/mycarlist";
    }

    @GetMapping("/mycar/mycarlist")
    public String mycarlist() {
        return "mycar/mycarlist";
    }

    @GetMapping("/mycar/mycarform")
    public String mycarform() {
        return "mycar/mycarform";
    }
}
