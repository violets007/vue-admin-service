package com.zixuan007.admin.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.zixuan007.admin.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zixuan007
 */
public class TokenUtil {

    private static final long EXPIRE_TIME = 15 * 60 * 1000;     //token过期时间暂定为15分钟
    private static final String TOKEN_SECRET = "token123";      //密钥盐


    /**
     * 生成头部信息  //对应jwt第一部分  头部信息
     *
     * @return
     */
    private static Map<String, Object> createHead() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("typ", "JWT");
        map.put("alg", "HS512");
        return map;
    }

    /**
     * 生成token
     *
     * @param
     * @return
     * @throws
     */
    public static String createToken(User user) throws JsonProcessingException {
        String token = Jwts.builder().setHeader(createHead())  //添加头部信息
                .setSubject("zixuan007")  //token得主题
                .claim("uid", user.getId())
                .claim("username", user.getUsername()) //自定义载荷
                .setIssuedAt(new Date())  //签发token时候得时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))  //过期时间
                .signWith(SignatureAlgorithm.HS256, "TOKEN_SECRET").compact(); //添加密匙并加密 生成token
        return token;

    }


    /**
     * 签名验证
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
           /* System.out.println("认证通过：");
            System.out.println("issuer: " + jwt.getIssuer());
            System.out.println("username: " + jwt.getClaim("username").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());*/
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(TOKEN_SECRET).
                    parseClaimsJws(token).getBody();
            return claims;

        } catch (Exception e) {
        }
        return null;
    }
}
