package com.Project.Task_Manager.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthencationHelper {

    private String secret="vdwvbuwbubcbehr79347h4chydchshhhhhioiydshfhiwq0r73409fhq48qbncqwijcndiuy0re80r087rfurfuufquddddjnbfhdsjk0udsk09ueqeqask8uerodasbcfuednwqako";
    private static final long JWT_TOKEN_VALIDITY = 60*60;
   public String getUsernameFromToken(String token){
        Claims claims=getClaimsFromToken(token);
        return claims.getSubject();
    }
    public Claims getClaimsFromToken(String token){
        Claims claims=Jwts.parser().setSigningKey(secret.getBytes()).build().parseClaimsJws(token).getBody();
        return claims;
    }
    public boolean isTokenExpired(String token){
        Claims claims=getClaimsFromToken(token);
        Date expDate=claims.getExpiration();
        return expDate.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String,Object> claims=new HashMap<>();
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000)).signWith(new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS512.getJcaName()), SignatureAlgorithm.HS512).compact();

    }
}
