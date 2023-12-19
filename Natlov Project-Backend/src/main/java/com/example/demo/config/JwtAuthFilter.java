package com.example.demo.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {
	private UserAuthenticationProvider userauthenticationprovider;

	public JwtAuthFilter(UserAuthenticationProvider userauthenticationprovider) {
		super();
		this.userauthenticationprovider = userauthenticationprovider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (header != null) {
			String[] elements = header.split(" ");
			if (elements.length == 2 && elements[0].equals("Bearer")) {
				try {
					SecurityContextHolder.getContext()
							.setAuthentication(userauthenticationprovider.validateToken(elements[1]));
				} catch (RuntimeException e) {
					SecurityContextHolder.clearContext();
				}
			}

		}
		filterChain.doFilter(request, response);
	}

}
