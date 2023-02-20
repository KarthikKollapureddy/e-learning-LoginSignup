package com.ELearning.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.RegisterDao;
import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MainServiceImpl implements MainService {
  
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	RegisterDao registerDao;
	
	@Autowired
	SecurityService securityService;
	
	@Override
	public List<?> loginUser(String userName, String pass) throws InvalidLogin {
		// TODO Auto-generated method stub
		LoginUser user = loginDao.findLoginUserByUserNameAndPass(userName, pass);
		if(user != null) {
			Map<String, String> tokenMap = securityService.getAuthToken(user);
			List<?> response = new ArrayList<>(List.of(tokenMap,user));
			return response;
		}
		throw new InvalidLogin();
		
		 
	}


	@Override
	public RegisterUser signUpUser(RegisterUser registerUser) throws UserAlredyExists {
		// TODO Auto-generated method student
		Optional<RegisterUser> user = Optional.ofNullable(registerDao.findRegisterUserByUserName(registerUser.getUserName()));
		if(user.isEmpty()) {
			registerDao.save(registerUser);
			LoginUser loginData = new LoginUser(registerUser.getUserName(), registerUser.getPass());
			loginDao.save(loginData);
			return registerUser;
		}
//		else if(user != null) {
//			throw new UserAlredyExists();
//		}
		else {
			throw new UserAlredyExists();
		}
	}


	@Override
	public LoginUser changePassword(String userName, String newPassword) throws UserNotFound {
		// TODO Auto-generated method stub
		Optional<RegisterUser> user = Optional.ofNullable(registerDao.findRegisterUserByUserName(userName));
		Optional<LoginUser> userLogin = Optional.ofNullable(loginDao.findLoginUserByUserName(userName));
		if(user.isEmpty() && userLogin.isEmpty()) {
			throw new UserNotFound();
			
		}
		else {
			userLogin.get().setPass(newPassword);
			user.get().setPass(newPassword);
			registerDao.saveAndFlush(user.get());
			loginDao.saveAndFlush(userLogin.get());
			
			return userLogin.get();
		}
		
	}
	
	


	

}
