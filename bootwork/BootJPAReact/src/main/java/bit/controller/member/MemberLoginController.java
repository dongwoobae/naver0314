package bit.controller.member;

import JWT.setting.JwtTokenProvider;
import JWT.setting.UserAuthentication;
import bit.data.member.MemberDto;
import bit.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot")
public class MemberLoginController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/member/insert")
    public String insertMember(@RequestParam("userid") String userid,
                               @RequestParam("passwd") String passwd,
                               @RequestParam("hp") String hp) {
        //passwd 는 암호화 후 db 저장
        String encodedPasswd = passwordEncoder.encode(passwd);
        MemberDto member = MemberDto.builder().
                hp(hp).
                userid(userid).
                passwd(encodedPasswd).
                build();
        memberService.insertMember(member);

        return encodedPasswd;
    }

    @GetMapping("/member/check")
    public boolean checkMember(@RequestParam("userid") String userid) {
        return memberService.getIdCheck(userid);
    }

    @GetMapping("/member/login")
    public Map<String,Object> login(@RequestParam("userid") String userid,
                                    @RequestParam("passwd") String passwd){
        Map<String,Object> map= new HashMap<>();
        //아이디에 해당하는 dto 얻기
        MemberDto dto=memberService.getLoginId(userid);
        if(dto==null){
            map.put("result",false);
        }else {
            //해당 id로 저장된 암호화 된 비번을 얻어야함
            String encodedPasswd=dto.getPasswd();
            boolean b=passwordEncoder.matches(passwd,encodedPasswd);
            if(b){
                map.put("result",true);
                //id와 비번이 맞으므로 토큰을 얻어서 map에 저장
                Authentication auth= new UserAuthentication(userid,null,null);
                String token= JwtTokenProvider.generateToken(auth,userid);
                map.put("token",token);
                map.put("tokenLength",token.length());
            }else {
                map.put("result","fail");
            }
        }
        return map;
    }

    @GetMapping("/member/list")
    public List<MemberDto> memberList(){
        return memberService.getAllMembers();
    }

}
