package xmt.item.webmanage.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xmt.item.util.AppResponse;
import xmt.item.webmanage.entity.AdminInfo;
import xmt.item.webmanage.service.AdminService;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     <bean id="userServiceImpl"
     class="cn.com.bochy.service.impl.UserServiceImpl"
     autowire="byName">
     </bean>

     <bean id="userDao"
     class="cn.com.bochy.dao.impl.UserDaoImpl">
     </bean>

     比如说如上这段代码，byName就是通过Bean的id或者name，byType就是按Bean的Class的类型
     * @Autowired通过Bytype,也就是calss = "cn.com.bochy.service.impl.UserServiceImpl"
     * 代码autowire="byName"意思是通过id="userDao"来查找Bean中的userDao对象
     */
    @Autowired
    private AdminService adminService;

    @ResponseBody
    @GetMapping("/xmt")
    public AdminInfo xmt(){
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminName("xumintao");
        return adminInfo;
    }

    /**
     * 首页数量
     * @return
     */
    //@RequestMapping注解加上后会将返回值解析成路径跳转，
    // 发生找不到的情况，所以需要加上@ResponseBody注解
        @GetMapping("/number/{nickname}")
//    @RequestMapping(value = "/number/{nickname}",method = RequestMethod.GET)
    @ResponseBody
    public AppResponse countNumber(@PathVariable("nickname") String nickname){
        return adminService.countNumber(nickname);
    }

    /**
     * 管理员登陆
     * @param adminInfo
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/login")
    @ResponseBody
    public AppResponse loginAdmin(AdminInfo adminInfo) throws UnsupportedEncodingException {
        return adminService.loginAdmin(adminInfo);
    }

    /**
     * 查询店长/分页查询
     * @param adminInfo
     * @return
     */
    @GetMapping("/selectStoreManage")
    public AppResponse selectStoreManage(AdminInfo adminInfo){
        return adminService.selectStoreManage(adminInfo);
    }

    /**
     * 查询管理员
     * @param adminInfo
     * @return
     */
    @GetMapping("/selectAdmin")
    public AppResponse selectAdmin(AdminInfo adminInfo){
        return adminService.selectAdmin(adminInfo);
    }

    /**
     * 新增管理员
     * @param adminInfo
     * @return
     */
    @GetMapping("/addAdmin")
    public AppResponse addAdmin(AdminInfo adminInfo){
        return adminService.addAdmin(adminInfo);
    }

    /**
     * 修改管理员
     * @param adminInfo
     * @return
     */
    @GetMapping("/updateAdmin")
    public AppResponse updateAdmin(AdminInfo adminInfo){
        return adminService.updateAdmin(adminInfo);
    }

    /**
     * 删除管理员
     * @param adminId
     * @return
     */
    @GetMapping("/deleteAdmin")
    public AppResponse deleteAdmin(String adminId){
        return adminService.deleteAdmin(adminId);
    }

}
