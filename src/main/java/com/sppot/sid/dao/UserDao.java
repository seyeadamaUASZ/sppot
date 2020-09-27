package com.sppot.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sppot.sid.models.User;

public interface UserDao extends JpaRepository<User, Long> {
	public User findUserByUsername(String username);
	
}
