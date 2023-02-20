package com.ELearning.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.RegisterDao;
import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
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
		LoginUser usr = loginDao.findLoginBeanByUserNameAndPass(userName, pass);
		if(usr != null) {
			Map<String, String> tokenMap = securityService.getAuthToken(usr);
			List<?> response = new ArrayList<>(List.of(tokenMap,usr));
			return response;
		}
		throw new InvalidLogin();
		
		 
	}


	@Override
	public RegisterUser signUpUser(RegisterUser registerUser) throws UserAlredyExists {
		// TODO Auto-generated method student
		Optional<RegisterUser> user = Optional.ofNullable(registerDao.findByUserName(registerUser.getUserName()));
		if(user != null) {
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
	
	


	

}
