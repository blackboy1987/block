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

@RestController("iconApiLogoutController")
@RequestMapping("/app/auth/out")
public class LogoutController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;


    /**
     * 退出
     * @return
     */
    @PostMapping
    public Result index (){
        userService.logout();
        return Result.success("");
    }
}
