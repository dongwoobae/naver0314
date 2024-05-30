package controller.guest;

import data.dto.GuestDto;
import data.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class GuestListController {
    @Autowired
    private GuestService guestService;

    @GetMapping("/guest/list")
    public String list(Model model) {
        List<GuestDto> list = guestService.selectAllGuest();

        model.addAttribute("list",list);
        return "guest/guestlist";
    }
}
