package com.Shopping.Cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Shopping.Cart.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

User save(User userEntity);
	@Query(value ="select * from user as u where u.email=:email and u.password=:password",nativeQuery = true)
	User finOneByEmailIgoneCaseAndPassword(
			String email, String password);
	
	

}

