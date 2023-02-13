package com.ELearning.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ELearning.bean.RegisterBean;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDao extends JpaRepository<RegisterBean,Integer>{

	RegisterBean findByUserName(String userName);

}
