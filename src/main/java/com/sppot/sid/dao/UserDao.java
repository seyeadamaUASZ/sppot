package com.sppot.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sppot.sid.models.User;

public interface UserDao extends JpaRepository<User, Long> {
	public User findUserByUsername(String username);
	
	//counting user in platform
	
	@Query("select count(u) from User u")
	public Integer compteUser();
	
}
