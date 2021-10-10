package xmt.item.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TokenUtil {
//    使用JWT得规定属性
    public static String getToken(String userId,String sec) throws UnsupportedEncodingException {
        return JWT.create().withAudience(userId).sign(Algorithm.HMAC256(sec));
    }
    public static Verification resolveToken(String token, String sec) throws UnsupportedEncodingException {
        return JWT.require(Algorithm.HMAC256(sec));
    }
}
