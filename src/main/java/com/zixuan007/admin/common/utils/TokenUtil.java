package com.zixuan007.admin.common.utils;


import com.zixuan007.admin.pojo.bo.UserBO;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author zixuan007
 */
public class TokenUtil {

    private static final long EXPIRE_TIME = 15 * 60 * 1000;     //token过期时间暂定为15分钟
    private static final String TOKEN_SECRET = "token123";      //密钥盐
    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    public static String createJwtToken(UserBO user) {
        //设置失效时间
        //获取当前时间
        long now = System.currentTimeMillis();
        //当前时间+有效时间=过期时间
        long exp = now + EXPIRE_TIME;
        //创建JwtBuilder

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(user.getId() + "")
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
                //添加非私密的其它内容
                .claim("uid", user.getId())
                .claim("username", user.getUsername());

        //设置失效时间
        jwtBuilder.setExpiration(new Date(exp));
        String token = jwtBuilder.compact();
        return token;
    }

    public static Claims parseToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {

            return null;
        } catch (UnsupportedJwtException e) {

            return null;
        } catch (MalformedJwtException e) {

            return null;
        } catch (SignatureException e) {

            return null;
        } catch (IllegalArgumentException e) {

            return null;
        }
        return claims;
    }

}
