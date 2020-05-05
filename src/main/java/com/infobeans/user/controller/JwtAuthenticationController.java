package com.infobeans.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infobeans.user.config.JwtTokenService;
import com.infobeans.user.model.User;
import com.infobeans.user.service.IUserService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {


	@Autowired
	IUserService userServiceImpl;

	@Autowired
	JwtAuthenticationService jwtAuthenticationService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {

		String token = jwtAuthenticationService.authenticate(authenticationRequest);

		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("message", "Token Created Success.");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public String addUser(@RequestBody User user) {

		ResponseEntity re = null;
		try {
			userServiceImpl.saveUser(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "User saved successfully.";
	}

	@GetMapping("/hello")
	public String testString() {

		return "User authenticated success.";
	}

}
