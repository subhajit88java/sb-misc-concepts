package com.subhajit.sbmiscconcepts.bcrypt.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BcryptController {
	
	@GetMapping("/bcrypt-encode")
	public String bcryptEncode() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A, 10);
		String password = "admin";
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println("Encoded password : " + encodedPassword);
		Boolean flag = passwordEncoder.matches("public-client", "$2a$10$ah1qSO1.0eOORsMfZUcgSuBXm6FLCRoe.sFtQnSzYI5K22RvyoeDO");
		System.out.println("flag : " + flag);
		return encodedPassword;
	}

}

//$2b$12$gua8KBBEyvHeuFTg7s8io.oS45Pn3ge8YHopgreTzOYgGgzsa2b4q
// salt - 28 chars from beginning
// real salt - starting from 3rd $ sign upto 28th chars
// $2b - version
// 12 - strength

// Encoding process :
// 1. A random salt is generated based on random number(system generated), version and strength(both user provided)
// 2. Raw password is hashed and appended with salt [ salt + hashed raw password]
// 3. Encoded password =  [ salt + hashed raw password]

// Decoding process :
// 1. Raw password is provided by user
// 2. Based on username the existing encoded is fetched from database or other repositories
// 3. Salt is then fetched from the fetched encoded password
// 4. That fetched salt is then reused to encode the raw password given by the user
// 5. If the generated encoded password matches with the encoded password provided by the user then user is allowed to login
