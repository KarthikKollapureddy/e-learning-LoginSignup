package com.ELearning.controller;



import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;

@RestController
@RequestMapping("/elearning/api")
@CrossOrigin(origins = "*")  
public class LoginController {




@Autowired
MainService mainService;
	
	
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> findUsr(@RequestBody LoginUser login) throws InvalidLogin{
		return new ResponseEntity<>(mainService.loginUser(login.getUserName(), login.getPass()),HttpStatus.OK);
		
	}
	

	
	@PostMapping("/register")
	public ResponseEntity<RegisterUser> saveUser(@RequestBody RegisterUser registerUser) throws UserAlredyExists {
		return new ResponseEntity<RegisterUser>(mainService.signUpUser(registerUser),HttpStatus.CREATED);
		
	}

}
