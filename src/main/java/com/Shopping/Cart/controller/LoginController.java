package com.Shopping.Cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Cart.DTO.LoginRequestDTO;
import com.Shopping.Cart.DTO.SignUpRequestDTO;
import com.Shopping.Cart.common.APIResponse;
import com.Shopping.Cart.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/signup")
	public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO)
	{
		APIResponse apiResponse=loginService.signUp(signUpRequestDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	@PostMapping("/login")
	public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO)
	{
		APIResponse apiResponse=loginService.login(loginRequestDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	

}
