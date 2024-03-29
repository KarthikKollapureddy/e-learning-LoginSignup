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
	public Map<String,String> loginUser(String userName, String pass) throws InvalidLogin {
		// TODO Auto-generated method stub
		LoginUser user = loginDao.findByUserNameAndPass(userName, pass);
		System.out.println("hii"+user);
		if(user != null) {
			Map<String, String> tokenMap = securityService.getAuthToken(user);
			System.out.print(tokenMap.get("message"));
			return tokenMap;
		}
		System.out.print("Hey"+user);
		throw new InvalidLogin();
		
		 
	}


	@Override
	public RegisterUser signUpUser(RegisterUser registerUser) throws UserAlredyExists {
		// TODO Auto-generated method student
		Optional<RegisterUser> user = Optional.ofNullable(registerDao.findByUserName(registerUser.getUserName()));
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
<<<<<<< HEAD
		Optional<RegisterUser> user = Optional.ofNullable(registerDao.findByUserName(userName));
		Optional<LoginUser> userLogin = Optional.ofNullable(loginDao.findByUserName(userName));
		if(user.isEmpty() && userLogin.isEmpty()) {
=======
//		System.out.println(userName);
		RegisterUser user = registerDao.findRegisterUserByUserName(userName);
		LoginUser userLogin = loginDao.findLoginUserByUserName(userName);
		if(user==null && userLogin ==null) {
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486
			throw new UserNotFound();

		}
		else {
			userLogin.setPass(newPassword);
				user.setPass(newPassword);
			registerDao.saveAndFlush(user);
			loginDao.saveAndFlush(userLogin);

			return userLogin;
		}


		
	}
	
	


	

}
