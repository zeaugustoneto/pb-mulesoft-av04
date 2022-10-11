package br.com.av04.paymentservicepb.config.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationByTokenFilter extends OncePerRequestFilter {






    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       	
			 UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(null,null,null);
		        SecurityContextHolder.getContext().setAuthentication(authentication);
		

        filterChain.doFilter(request,response);

    }


    private String recuperarToken(HttpServletRequest request) {
        String token =  request.getHeader("Authorization");
        // ***********espaço após Bearer***********
        if(token == null  || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7,token.length());
    }
}
