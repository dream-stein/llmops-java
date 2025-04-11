package com.emcikem.llm.service.service.account;

import com.emcikem.llm.common.util.GsonUtil;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * Create with Emcikem on 2025/4/8
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class JWTService {


//    @Value("${jwt.secret}") // 从 application.yml 读取密钥
    private String jwtSecret;

//    @Value("${jwt.expiration}") // Token 有效期（毫秒）
    private long jwtExpiration;

    /**
     * 生成token
     * @param payload
     * @return
     */
    public String generateToken(Map<String, String> payload) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtExpiration);

        return Jwts.builder()
                .setSubject(GsonUtil.toJSONString(payload))
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public Map<String, String> parseToken(String token) {
        String subject = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
        return GsonUtil.gsonToMaps(subject);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJwt(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
}
