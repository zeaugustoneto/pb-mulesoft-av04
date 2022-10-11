package br.com.av04.paymentservicepb.config.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
