package com.jeffnalex.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static String signKey = "jef2un628";
    /**
     * 生成jwt
     * 使用Hs256算法, 私匙使用固定秘钥
     */
    public static String createJWT(Map<String, Object> claims) {
        // 指定簽名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成ＪＷＴ過期時間
        Date exp = new Date(System.currentTimeMillis() + 3600*1000);

        // 設置ＪＷＴ
        JwtBuilder builder = Jwts.builder()
                // 設置私有聲明（通常都是放id,username）
                .setClaims(claims)
                // 設置簽名算法和簽名使用密鑰
                .signWith(signatureAlgorithm, signKey)
                // 設置過期時間
                .setExpiration(exp);

        return builder.compact();
    }

    /**
     * Token解析
     * @return
     */
    public static Claims parseJWT(String token) {
        // 得到DefaultJwtParser
        Claims claims = Jwts.parser()
                // 設置簽名密鑰
                .setSigningKey(signKey)
                // 賦予需要解析的jwt
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
