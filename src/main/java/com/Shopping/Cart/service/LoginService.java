package com.Shopping.Cart.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Shopping.Cart.DTO.LoginRequestDTO;
import com.Shopping.Cart.DTO.SignUpRequestDTO;
import com.Shopping.Cart.common.APIResponse;
import com.Shopping.Cart.entity.User;
import com.Shopping.Cart.repository.LoginRepo;
import com.Shopping.Cart.repository.UserRepo;
import com.Shopping.Cart.util.JwtUtils;
@Service
public class LoginService {
	//@Autowired
	//private LoginRepo loginRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired 
	private JwtUtils jwtUtils;
	public APIResponse signUp(SignUpRequestDTO signUpRequestDTO)
	{
		APIResponse apiResponse=new APIResponse();
		User userEntity=new User();
	
	userEntity.setName(signUpRequestDTO.getName());
		userEntity.setGender(signUpRequestDTO.getGender());
		userEntity.setEmail(signUpRequestDTO.getEmail());
		userEntity.setPhoneno(signUpRequestDTO.getPhoneno());
		userEntity.setPassword(signUpRequestDTO.getPassword());
		
		userEntity=userRepo.save(userEntity);
		if (userEntity != null) {
			apiResponse.setStatus(HttpStatus.OK.value());
			apiResponse.setData(userEntity);
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apiResponse.setError("bad request");
		}
		return apiResponse;
	}
	public APIResponse login(LoginRequestDTO loginRequestDTO)
	{
		APIResponse apiResponse=new APIResponse();
		User user=userRepo.finOneByEmailIgoneCaseAndPassword(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());
		if (user != null) {
			apiResponse.setData("Loged in");
			apiResponse.setStatus(HttpStatus.OK.value());
			String token = jwtUtils.generateJWT(user);
			Map<Object, Object> data = new HashMap<Object, Object>();
			data.put(user, token);
			apiResponse.setData(data);
			return apiResponse;
		} else {
			apiResponse.setData("User login failed");
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apiResponse.setError("incorrect passward or emailId");
			return apiResponse;
		}

		
		
		
		
		//return apiResponse;	
	}

}
	