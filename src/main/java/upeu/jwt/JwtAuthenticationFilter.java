package upeu.jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String token = getTokenFromRequest(request);
		if(token==null) {
			filterChain.doFilter(request, response);
			return;	
		}
		filterChain.doFilter(request, response);
		
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(org.springframework.util.StringUtils.hasText(authHeader)&& authHeader.startsWith("bearer")) {
			return authHeader.substring(7);
		}
		return null;
	}

}
