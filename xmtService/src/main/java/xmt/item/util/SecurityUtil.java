package xmt.item.util;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 许民涛
 */
public class SecurityUtil {
    /**
     * 生成加密密码
     */
    public static String encryptPassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new  BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        return encodePassword;
    }

    /**
     * 密码是否相同
     */
    public static Boolean resolvePassword(String rawPassword, String encodedPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(rawPassword,encodedPassword);
    }

}
