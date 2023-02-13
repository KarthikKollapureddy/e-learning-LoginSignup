package com.ELearning.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.RegisterDao;
import com.ELearning.bean.LoginBean;
import com.ELearning.bean.RegisterBean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainServiceImpl implements MainService {
  
	@Autowired
	LoginDao lg;
	
	@Autowired
	RegisterDao rg;
	
	@Override
	public LoginBean loginUser(String userName, String pass) {
		// TODO Auto-generated method stub
		return lg.findLoginBeanByUserNameAndPass(userName, pass);
		 
		
	}

	@Override
	public RegisterBean signUp(RegisterBean reg) {
		// TODO Auto-generated method student
		return rg.save(reg) ;
	}

	@Override
	public RegisterBean fetchByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		Optional<RegisterBean> user = Optional.ofNullable(rg.findByUserName(userName));
		if(user.isPresent()){
		return rg.findByUserName(userName);}
		else{
			return null;
		}
	}

	@Override
	public void saveDet(LoginBean log) {
		// TODO Auto-generated method stub
		
		lg.save(log);
		
	}
	
	

}
