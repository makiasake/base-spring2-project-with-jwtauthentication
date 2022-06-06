package com.makiasake.basespring2withjwtauthentication.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makiasake.basespring2withjwtauthentication.security.JWTUtil;
import com.makiasake.basespring2withjwtauthentication.security.UserSS;
import com.makiasake.basespring2withjwtauthentication.services.UserAccountService;

@RestController
@RequestMapping(value="auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value="/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserAccountService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}
}
