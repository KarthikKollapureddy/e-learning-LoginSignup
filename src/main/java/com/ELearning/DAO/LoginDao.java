package com.ELearning.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ELearning.bean.LoginBean;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends JpaRepository<LoginBean, Integer> {
	
	LoginBean findLoginBeanByUserNameAndPass(String username,String pwd);

}
