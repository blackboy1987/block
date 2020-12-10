package net.bdsc.controller.api;

import net.bdsc.common.Result;
import net.bdsc.entity.Member;
import net.bdsc.security.UserAuthenticationToken;
import net.bdsc.service.MemberService;
import net.bdsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController("iconApiLoginController")
@RequestMapping("/app/auth/login")
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;


    /**
     * 登录
     * @param phone
     * @param password
     * @param umeng
     * @param mobile
     * @param uuid
     * @return
     */
    @PostMapping
    public Result index (String phone, String password, String umeng, String mobile, String uuid, HttpServletRequest request){
        Member member = memberService.findByMobile(phone);
        if(member==null){
            return Result.error("手机号输入错误");
        }
        if(!member.isValidCredentials(password)){
            return Result.error("密码错误");
        }
        Map<String,Object> data = new HashMap<>();
        data.put("id",member.getId());
        data.put("userName",member.getUsername());
        data.put("code",member.getId()+"");
        data.put("addPass",true);
        data.put("activation",true);
        //成功： {"type":200,"content":"请求成功","data":{"code":"10051","addPass":true,"id":10051,"userName":"blackboy","activation":true}}
        //失败： {"type":400,"content":"手机号输入错误","date":null,"code":null,"message":null}
        userService.login(new UserAuthenticationToken(Member.class, member.getUsername(), password, false, request.getRemoteAddr()));

        return Result.success(data);
    }
}
