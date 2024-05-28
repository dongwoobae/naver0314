package controller.board;

import data.service.ReBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardDetailDeleteController {
    @Autowired
    private ReBoardService reBoardService;

    @GetMapping("/detail")
    public String detail() {

        return "board/detailpage";
    }
}
