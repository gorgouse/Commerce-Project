package xmt.item.webapp.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import xmt.item.util.*;
//import xmt.item.util.SecurityUtil;
import xmt.item.webapp.dao.UserDao;
import xmt.item.webapp.entity.UserInfo;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.List;
import javax.annotation.Resource;

@Service
@Transactional
public class UserService {
   @Resource
   private UserDao userDao;

    /**
     * 客户注册
     * @param userInfo
     * @return
     */
    public AppResponse register(UserInfo userInfo){
        UserInfo userInfoDATA = new UserInfo();
        userInfoDATA.setUsername(userInfo.getUsername());
        int verify1 = userDao.hasAlreadyAcctAndPhone(userInfoDATA);
        if(verify1 != 0){
            return AppResponse.versionError("账号已存在");
        }
        UserInfo userInfoData2 = new UserInfo();
        userInfoData2.setPhone(userInfo.getPhone());
        int verify2 = userDao.hasAlreadyAcctAndPhone(userInfoData2);
        if(verify2 != 0){
            return AppResponse.versionError("该手机号已被注册");
        }
        userInfo.setPassword(SecurityUtil.encryptPassword(userInfo.getPassword()));
        userInfo.setId(StringUtil.getCommonCode(3));
        int result = userDao.register(userInfo);
        if(result == 0){
            return AppResponse.versionError("Register fail!",1);
        }
        return AppResponse.success("register successfully",0);
    }

    /**
     * 客户登录
     * @param userInfo
     * @return
     * @throws UnsupportedEncodingException
     */
   public AppResponse clientLogin(UserInfo userInfo) throws Exception {
//       RSA
       String privateKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIfr6m4J8l8BYvAh4Cq9997g" +
               "el2v7ZbsIj2nl2CwuG1cq8/H4tYC7JMaynA2VD0OkFO9ASmCcVeSJQY70PASUmB6QAbsRvdEY33ZZBfYGnO9udmsN" +
               "hVlP1tPGQ19QAFzbORIbbvyd0Lp7X+DKuTHusaQu+Ue9nArHL1g9gkvjiwHAgMBAAECgYBUBDHOfvuAWl0LzgTApthWvi" +
               "8lRh/4kFHCBpv9un7lqsjREN9YJkqRy5eisRJ1A1GXUVcsj2L8HGwiZEsMembML7ifPReXVYieXPCOIFuPZWwmlBWh3ime" +
               "U2YvCrvMjG3wQIIlGpWpqjdPX683DYxUF2wAxSRupZ98lvEctU+1oQJBANKFSUSD8Sz9zXKL9xbn24XHshMvWNIkxONtvy" +
               "Jh8Vf3omFEWPtlw6ekSQSAmOhpk6CLyAq5QMtGdHGWZTA+8K8CQQClSPjyLJSwQHfiMZQ66WrNCWXETOhoT9t10KA2BRVmyF" +
               "QMrxU0zecmrTORpSKTjRjHAoyfUm6rXbI9QY/2SGApAkEAna0S6WxhcS9Pd6H5mYBjXVnquI/X2N2NUkJazCfLmfVx+6QzeWgJ" +
               "GUDlJ6gh3sFkvvSzCcUjEJ1ejcz1USNzJQJAZJPrKTMHp9kTGomg8dhoLSyyyKkkI5W0rhSt6TFevJTa0H0aIm/JYTe0UcRzLeaG" +
               "VVOvzqOSxKTXeX8T44JXQQJAdvTiEX9a9mvOC8J3893bENv5pfpCOMQKsjyHeMxoS7wJ6rxwoH0KYNWrycYGmpBEcZUgcz8RQ+oe" +
               "aLDFicudEw==";
       String after = new String(RSACoder.decryptByPrivateKey(userInfo.getPassword(),privateKey));
//       System.out.println("解密后的密码"+after);
       userInfo.setPassword(after);
       UserInfo userInfo1 = userDao.clientLogin(userInfo);
       if(userInfo1 == null){
           return AppResponse.versionError("账号输入有误!");
       }
       Boolean ensure = SecurityUtil.resolvePassword(userInfo.getPassword(),userInfo1.getPassword());
       if(ensure == false){
           return AppResponse.versionError("密码输入有误!");
       }
//       JWT
       String SecretKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAqhHyZfSsYourNxaY\\n' +\n" +
               "  '7Nt+PrgrxkiA50efORdI5U5lsW79MmFnusUA355oaSXcLhu5xxB38SMSyP2KvuKN\\n' +\n" +
               "  'PuH3owIDAQABAkAfoiLyL+Z4lf4Myxk6xUDgLaWGximj20CUf+5BKKnlrK+Ed8gA\\n' +\n" +
               "  'kM0HqoTt2UZwA5E2MzS4EI2gjfQhz5X28uqxAiEA3wNFxfrCZlSZHb0gn2zDpWow\\n' +\n" +
               "  'cSxQAgiCstxGUoOqlW8CIQDDOerGKH5OmCJ4Z21v+F25WaHYPxCFMvwxpcw99Ecv\\n' +\n" +
               "  'DQIgIdhDTIqD2jfYjPTY8Jj3EDGPbH2HHuffvflECt3Ek60CIQCFRlCkHpi7hthh\\n' +\n" +
               "  'YhovyloRYsM+IS9h/0BzlEAuO0ktMQIgSPT3aFAgJYwKpqRYKlLDVcflZFCKY7u3\\n' +\n" +
               "  'UP8iWi1Qw0Y=";
       String token = TokenUtil.getToken(userInfo1.getId(),SecretKey);
       Jedis jedis = new Jedis("127.0.0.1",6379);
       jedis.set(userInfo1.getId(),token);
       System.out.println("id为"+userInfo1.getId()+"的客户携带token为"+token+"登陆了客户端");
       System.out.println("token保存成功");
           userInfo1.setToken(token);
//           userInfo1.setPassword("");
//           userInfo1.setUsername("");
//           userInfo.setPhone("");
//           userInfo1.setNickname("");
       userDao.addPageView();
       return AppResponse.success("Login Successfully", userInfo1);
   }

    /**
     * 用户详情
     * @param userInfo
     * @return
     */
    public AppResponse getDetail(UserInfo userInfo){
        UserInfo userInfo1 = userDao.getDetail(userInfo);
        return AppResponse.success("查询成功",userInfo1);
    }
}
