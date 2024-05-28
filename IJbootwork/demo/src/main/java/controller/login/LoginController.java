package controller.login;

import data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class LoginController {
    @Autowired
    private MemberService memberService;

    @ResponseBody
    @GetMapping("/loginGo")
    public Map<String, String> isLogin(
            @RequestParam(defaultValue = "no") String saveid,
            @RequestParam String myid,
            @RequestParam String pass,
            HttpSession session
    ) {
        Map<String, String> map = new HashMap<>();

        boolean loginStatus = memberService.isLoginCheck(myid,pass);
        if(loginStatus) {
            map.put("status", "success");
            session.setAttribute("loginid", myid);
            session.setAttribute("saveid", saveid.equals("no")?"no":"yes");
            session.setAttribute("loginok","yes");
        }else {
            map.put("status", "fail");
        }
        return map;
    }

    @ResponseBody
    @GetMapping("/logout")
    public void memberLogout(HttpSession session) {
        session.removeAttribute("loginok");
    }
}
