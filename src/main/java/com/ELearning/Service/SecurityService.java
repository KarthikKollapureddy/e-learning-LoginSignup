package com.ELearning.Service;

import java.util.Map;

import com.ELearning.bean.LoginBean;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
	
	Map<String,String> getAuthToken(LoginBean log);

}
