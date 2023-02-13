package com.ELearning.Service;

import com.ELearning.bean.LoginBean;
import com.ELearning.bean.RegisterBean;
import org.springframework.stereotype.Service;

@Service

public interface MainService
{
	
	public LoginBean loginUser(String userName,String pass);
	
	public RegisterBean signUp(RegisterBean reg);

	public RegisterBean fetchByUserName(String userName) throws Exception;

	public void saveDet(LoginBean log);

}
