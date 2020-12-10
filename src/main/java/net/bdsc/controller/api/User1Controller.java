package net.bdsc.controller.api;

import net.bdsc.common.Result;
import net.bdsc.entity.Member;
import net.bdsc.security.CurrentUser;
import net.bdsc.service.BitCoinAccountService;
import net.bdsc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController("iconUserController")
@RequestMapping("/user")
public class User1Controller {

    @RequestMapping("/electric/page")
    public Result moneyList(@CurrentUser Member member,HttpServletRequest request){
        return Result.success("没有更多数据了");
    }
}
