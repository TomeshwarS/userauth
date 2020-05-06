package com.infobeans.user.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.infobeans.user.config.JwtTokenService;
import com.infobeans.user.model.User;

@Service
public class JwtAuthenticationService {
	
	
	private static Logger logger = LoggerFactory.getLogger(JwtAuthenticationService.class);

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenService jwtTokenService;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	public String authenticate(User authenticationRequest) {

		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPass());
		} catch (Exception e) {
			e.printStackTrace();
		}

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenService.generateToken(userDetails);
		return token;
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@GetMapping("/hello")
	public String getMessage() {
		
	return "his is Testig String.";
	}
}
