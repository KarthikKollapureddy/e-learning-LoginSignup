package com.ELearning.controller;

import java.util.Map;

import com.ELearning.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ELearning.Service.SecurityService;
import com.ELearning.bean.LoginBean;
import com.ELearning.bean.RegisterBean;

@RestController
@RequestMapping("/elearning/api")
@CrossOrigin(origins = "*")  
public class LoginController {





MainService ms;
	
	@Autowired
	SecurityService securityService;
	@PostMapping("/login")
	 public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginBean login) throws Exception{
		
		System.out.print(login.getUserName());
		LoginBean log=null;
		log=ms.loginUser(login.getUserName(),login.getPass());
		if(log!=null) {
			 Map<String, String> tokenMap = securityService.getAuthToken(log);
			 return ResponseEntity.status(HttpStatus.OK).body(tokenMap);
		}
		else {
			throw new Exception("Bad Credentials");
		}
 
		
		
		
	}
	
	@PostMapping("/register")
	public RegisterBean saveUser(@RequestBody RegisterBean reg) throws Exception{
		RegisterBean register=ms.fetchByUserName(reg.getUserName());
		System.out.println(register);

		if(register!=null) {
			throw new Exception("User with this username or email id already exists...");
		}
		else {
			register=ms.signUp(reg);
			LoginBean log=new LoginBean(register.getUserName(),register.getPass());
			ms.saveDet(log);
		}
		
		return register;
		
	}

}
