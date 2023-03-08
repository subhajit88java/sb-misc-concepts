package com.subhajit.sbmiscconcepts.bcrypt.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BcryptController {
	
	@GetMapping("/bcrypt-encode")
	public String bcryptEncode() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A, 12);
		String password = "a";
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println("Encoded password : " + encodedPassword);
		Boolean flag = passwordEncoder.matches("a", encodedPassword);
		return encodedPassword;
	}

}
