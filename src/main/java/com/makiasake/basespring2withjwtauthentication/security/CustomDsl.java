package com.makiasake.basespring2withjwtauthentication.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

	private UserDetailsService userDetailsService;
	private JWTUtil jwtUtil;
	
	public CustomDsl(JWTUtil jwtUtil, UserDetailsService userDetailsService) {
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
		http.addFilterBefore(new JWTAuthenticationFilter(authenticationManager, jwtUtil), UsernamePasswordAuthenticationFilter.class);
		http.addFilter(new JWTAuthorizationFilter(authenticationManager, jwtUtil, userDetailsService));
	}

	public static CustomDsl customDsl(JWTUtil jwtUtil, UserDetailsService userDetailsService) {
		return new CustomDsl(jwtUtil, userDetailsService);
	}
}
