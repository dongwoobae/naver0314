package controller.guest;

import data.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestListController {
    @Autowired
    private GuestService guestService;

    @GetMapping("/guest/list")
    public String list() {

        return "guest/guestlist";
    }
}
