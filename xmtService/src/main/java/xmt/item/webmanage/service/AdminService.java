package xmt.item.webmanage.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import xmt.item.util.AppResponse;
import xmt.item.util.SecurityUtil;
import xmt.item.util.StringUtil;
import xmt.item.util.TokenUtil;
import xmt.item.webmanage.dao.AdminDao;
import xmt.item.webmanage.entity.AdminInfo;
import xmt.item.webmanage.entity.NumberInfo;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Service
public class AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 首页数量
     * @return
     */
    public AppResponse countNumber(String a){
        NumberInfo numberInfo1 = adminDao.countClientNumber();
        NumberInfo numberInfo2 = adminDao.countOrderNumber();
        NumberInfo numberInfo3 = adminDao.countPageViewNumber();
        NumberInfo numberInfo = new NumberInfo();
        numberInfo.setClientNumber(numberInfo1.getClientNumber()+a);
        numberInfo.setOrderNumber(numberInfo2.getOrderNumber()+a);
        numberInfo.setPageViewNumber(numberInfo3.getPageViewNumber()+a);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("成功");
        stringBuffer.append(a);
        return AppResponse.success(stringBuffer.toString(),numberInfo);
    }

    /**
     * 管理员登陆
     * @param adminInfo
     * @return
     * @throws UnsupportedEncodingException
     */
    public AppResponse loginAdmin(AdminInfo adminInfo) throws UnsupportedEncodingException {
        AdminInfo loginData = adminDao.loginAdmin(adminInfo);
        if(loginData == null){
            loginData = adminDao.loginStore(adminInfo);
        }
        Boolean result = SecurityUtil.resolvePassword(adminInfo.getPassword(),loginData.getPassword());
        if(result == false){
            return AppResponse.versionError("账号或密码输入错误","Input Error ! Try again !");
        }
        String SecretKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAqhHyZfSsYourNxaY\\n' +\n" +
                "  '7Nt+PrgrxkiA50efORdI5U5lsW79MmFnusUA355oaSXcLhu5xxB38SMSyP2KvuKN\\n' +\n" +
                "  'PuH3owIDAQABAkAfoiLyL+Z4lf4Myxk6xUDgLaWGximj20CUf+5BKKnlrK+Ed8gA\\n' +\n" +
                "  'kM0HqoTt2UZwA5E2MzS4EI2gjfQhz5X28uqxAiEA3wNFxfrCZlSZHb0gn2zDpWow\\n' +\n" +
                "  'cSxQAgiCstxGUoOqlW8CIQDDOerGKH5OmCJ4Z21v+F25WaHYPxCFMvwxpcw99Ecv\\n' +\n" +
                "  'DQIgIdhDTIqD2jfYjPTY8Jj3EDGPbH2HHuffvflECt3Ek60CIQCFRlCkHpi7hthh\\n' +\n" +
                "  'YhovyloRYsM+IS9h/0BzlEAuO0ktMQIgSPT3aFAgJYwKpqRYKlLDVcflZFCKY7u3\\n' +\n" +
                "  'UP8iWi1Qw0Y=";

        String token = TokenUtil.getToken(loginData.getId(),SecretKey);
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set(loginData.getId(),token);
        System.out.println("管理员id为"+loginData.getId()+"携带token:"+token+"登录了管理端");
        System.out.println("Token Save Successfully");
        loginData.setToken(token);
        adminDao.addPageView();
        return AppResponse.success("登录成功",loginData);
    }

    /**
     * 查询店长/分页查询
     * @param adminInfo
     * @return
     */
    public AppResponse selectStoreManage(AdminInfo adminInfo){
        List<AdminInfo> adminInfoList = adminDao.selectStoreManage(adminInfo);
        for(AdminInfo adminInfo1:adminInfoList){
            adminInfo1.setRole("店家");
        }
        return AppResponse.success("成功",adminInfoList);
    }

    /**
     * 查询管理员
     * @param adminInfo
     * @return
     */
    public AppResponse selectAdmin(AdminInfo adminInfo){
        List<AdminInfo> adminInfoList = adminDao.selectAdmin(adminInfo);
        for(AdminInfo adminInfo1:adminInfoList){
            if(adminInfo1.getRole().equals("1")){
                adminInfo1.setRole("超级管理员");
            }
            if(adminInfo1.getRole().equals("2")){
                adminInfo1.setRole("管理员");
            }
            if(adminInfo1.getRole().equals("3")){
                adminInfo1.setRole("店家");
            }
        }
        return AppResponse.success("成功",adminInfoList);
    }

    /**
     * 新增管理员
     * @param adminInfo
     * @return
     */
    public AppResponse addAdmin(AdminInfo adminInfo){
        if(adminInfo.getRole().equals("1")){
            adminInfo.setId(StringUtil.getCommonCode(1));
        }
        else{
            adminInfo.setId(StringUtil.getCommonCode(1));
        }
        String username = adminInfo.getUsername();
        List<AdminInfo> adminInfoList = adminDao.exitAccount(username);
        if(adminInfoList.size() != 0){
            return AppResponse.bizError("该账号已经存在");
        }
        adminInfo.setPassword(SecurityUtil.encryptPassword(adminInfo.getPassword()));
        int add = adminDao.addAdmin(adminInfo);
        return AppResponse.success("成功",add);
    }

    /**
     * 修改管理员
     * @param adminInfo
     * @return
     */
    public AppResponse updateAdmin(AdminInfo adminInfo){
        if(adminInfo.getPassword()!= null){
            adminInfo.setPassword(SecurityUtil.encryptPassword(adminInfo.getPassword()));
        }
        int update = adminDao.updateAdmin(adminInfo);
        return AppResponse.success("成功",update);
    }

    /**
     * 删除管理员
     * @param adminInId
     * @return
     */
    public AppResponse deleteAdmin(String adminInId){
        int delete = adminDao.deleteAdmin(adminInId);
        return AppResponse.success("成功",delete);
    }

}
