package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.*;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.UserInfo;
import xmt.item.webapp.service.UserService;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class UserController{

    @Resource
    public UserService userService;

    /**
     * 客户注册
     * @param userInfo
     * @return
     */
    @GetMapping("/registerUser")
    public AppResponse register(UserInfo userInfo){
        return userService.register(userInfo);
    }

    /**
     * 客户登录
     * @param userInfo
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/loginUser")
   public AppResponse userLogin(UserInfo userInfo) throws Exception {
       return userService.clientLogin(userInfo);
   }

    /**
     * 用户详情
     * @param userInfo
     * @return
     */
   @GetMapping("/getDetail")
    public AppResponse getDetail(UserInfo userInfo){
        return userService.getDetail(userInfo);
   }
}
