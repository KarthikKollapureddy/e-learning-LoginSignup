package com.ELearning.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.model.LoginUser;
//import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;

@Service

public interface MainService
{
	
	public List<?> loginUser(String userName,String pass) throws InvalidLogin;
	
	public RegisterUser signUpUser(RegisterUser registerUser) throws UserAlredyExists;

	LoginUser changePassword(String userName,String newPassword) throws UserNotFound;

	

}
