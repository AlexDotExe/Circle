package com.x.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.x.dto.AuthenticationResponse;
import com.x.dto.LoginRequest;
import com.x.dto.RegisterRequest;
import com.x.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
	
	 private final AuthService authService;

	 @PostMapping("/signup")
	    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
	        authService.signup(registerRequest);
	        return new ResponseEntity<>("User Registration Successful", OK);
	    }
	 @PostMapping("/login")
	    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
	        return authService.login(loginRequest);
	    }
    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successully", OK);
    }
}
