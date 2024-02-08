package com.Shopping.Cart.util;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.Shopping.Cart.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static String secret="This_is_secret";
	private static int expiryDuration=60*60;
	public String generateJWT(User user)
	{
		//Long expiration=System.currentTimeMillis();
		Long millseconds=System.currentTimeMillis();
		Long expiration1=millseconds+expiryDuration*1000;
		Date issuedAt=new Date(millseconds);
		Date expiryAt=new Date(expiration1);
		
		Claims claims=Jwts.claims().setIssuer(user.toString()).setIssuedAt(issuedAt).setExpiration(expiryAt);
		claims.put("name",user.getEmail());
		claims.put("email",user.getPassword());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	public Claims verify(String authorization) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
            return claims;
        } catch(Exception e) {
            throw new AccessDeniedException("Access Denied");
        }

    }
	

}
