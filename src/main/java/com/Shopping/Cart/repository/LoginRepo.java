package com.Shopping.Cart.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Shopping.Cart.entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login,Integer>{

	//User save(User userEntity);
	//@Query(value ="select * from log as u where u.email=:email and u.password=:password",nativeQuery = true)
	//User finOneByEmailIgoneCaseAndPassword(String email, String password);

}
