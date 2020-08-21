package com.lixiande.eblog.utils;

import com.lixiande.eblog.shiro.JWTFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.PrimitiveIterator;

@Data
@Component
@Slf4j
public class JWTutils {
    public String secret;
    private long expire;
    private String header;

    public String generateToken(long userId){
        Date nowDate=new Date();
        Date expireDate = new Date(nowDate.getTime()+expire*1000);
        return Jwts.builder().setHeaderParam("type","JWT").setSubject(userId+" ").setIssuedAt(nowDate).setExpiration(expireDate)
                .signWith(SignatureAlgorithm.ES256,secret).compact();
    }

    public Claims getClaimByToken(String token){
        try{
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }
        catch (Exception e){
            log.debug("validate is token error" , e);
            return null;
        }
    }


    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }
}
