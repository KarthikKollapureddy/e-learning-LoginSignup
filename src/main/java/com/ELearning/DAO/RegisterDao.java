package com.ELearning.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ELearning.model.RegisterUser;

@Repository
public interface RegisterDao extends JpaRepository<RegisterUser,Integer>{

	RegisterUser findByUserName(String userName);
	
	RegisterUser findRegisterBeanByUserNameAndPass(String uName,String pass);

}
