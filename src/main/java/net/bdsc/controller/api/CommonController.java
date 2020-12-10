package net.bdsc.controller.api;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import net.bdsc.common.Result;
import net.bdsc.entity.Member;
import net.bdsc.service.AdversiteService;
import net.bdsc.service.MemberService;
import net.bdsc.util.CodeUtils;
import net.bdsc.util.SmsUtils;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController("iconApiCommonController")
@RequestMapping("/app/common")
public class CommonController {

    @Autowired
    private AdversiteService adversiteService;
    /**
     * CacheManager
     */
    private static final Ehcache cache = CacheManager.create().getCache("smsCode");

    @Autowired
    private MemberService memberService;

    @RequestMapping("/news-readNum")
    public Result newsReadNum(Long userId){
        System.out.println("news-readNum:"+userId);
        return Result.success(0);
    }
    @RequestMapping("/adversite")
    public Result adversite(){
        return Result.success(adversiteService.findAll());
    }

    @PostMapping("/code/phone/add_user")
    public Result phoneAddUser(String tel){
        boolean b = memberService.mobileExists(tel);
        if(b){
            return Result.error("手机号码已注册，获取验证码失败");
        }
        String code = CodeUtils.create(6);
        System.out.println(code);
        String result = SmsUtils.send(tel,"【xxx】 您正在注册*** ，本次验证码为："+code+"。10分钟之内有效！");
        if(StringUtils.equalsIgnoreCase("0",result)){

            // 发送成功写入到缓存
            cache.put(new Element(tel,code));
            return Result.success("");
        }else{
            return Result.error("验证码发送失败！");
        }
    }


    @PostMapping("/code/phone/forget_pass")
    public Result phoneForgetPass(String tel){
        Member member = memberService.findByMobile(tel);
        if(member==null){
            return Result.error("该手机号暂未注册！");
        }
        String code = CodeUtils.create(6);
        System.out.println(code);
        String result = SmsUtils.send(tel,"【xxx】 您正进行重置密码操作 ，本次验证码为："+code+"。10分钟之内有效！");
        if(StringUtils.equalsIgnoreCase("0",result)){
            // 发送成功写入到缓存
            cache.put(new Element(tel,code));
            return Result.success("");
        }else{
            return Result.error("验证码发送失败！");
        }
    }

    @PostMapping("/online")
    public Result online(Long userId,Boolean online,HttpServletRequest request){
       Member member = memberService.getCurrent(request);
       if(member==null){
           member = memberService.find(userId);
       }
       if(member==null){
           return Result.error("请先登录");
       }

        return Result.success("离线");
    }

    @PostMapping("/oss/sts/token")
    public Result ossStsToken(){
        Map<String,Object> result = new HashMap<>();
        result.put("accessid","accessid");
        result.put("policy","policy");
        result.put("signature","signature");
        result.put("dir","dir");
        result.put("host","host");
        result.put("expire","expire");
        return Result.success(result);
    }


    public static void main(String[] args) {
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        String AccessKeyId = "<access-key-id>";
        String accessKeySecret = "<access-key-secret>";
        String roleArn = "<role-arn>";
        String roleSessionName = "<session-name>";
        String policy = "{\n" +
                "    \"Version\": \"1\", \n" +
                "    \"Statement\": [\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"oss:*\"\n" +
                "            ], \n" +
                "            \"Resource\": [\n" +
                "                \"acs:oss:*:*:*\" \n" +
                "            ], \n" +
                "            \"Effect\": \"Allow\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        try {
            // 添加endpoint（直接使用STS endpoint，前两个参数留空，无需添加region ID）
            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
            // 构造default profile（参数留空，无需添加region ID）
            IClientProfile profile = DefaultProfile.getProfile("", AccessKeyId, accessKeySecret);
            // 用profile构造client
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setPolicy(policy); // 若policy为空，则用户将获得该角色下所有权限
            request.setDurationSeconds(1000L); // 设置凭证有效时间
            final AssumeRoleResponse response = client.getAcsResponse(request);
            System.out.println("Expiration: " + response.getCredentials().getExpiration());
            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
            System.out.println("RequestId: " + response.getRequestId());
        } catch (ClientException e) {
            System.out.println("Failed：");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg());
            System.out.println("RequestId: " + e.getRequestId());
        }
    }

}
