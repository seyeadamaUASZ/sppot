package com.sppot.sid.metiers.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;

import com.sppot.sid.dao.UserDao;
import com.sppot.sid.metiers.interfaces.IUser;
import com.sppot.sid.models.User;


@Service
public class UserImpl implements IUser {
	
	@Autowired
	private UserDao userdao;

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userdao.save(user);
	}

	@Override
	public User updateUser(Long id,User useru) {
		// TODO Auto-generated method stub
		useru.setId(id);
		return userdao.saveAndFlush(useru);
	}

	@Override
	public boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		User user = userdao.findById(id).get();
		if(user !=null) {
			userdao.deleteById(user.getId());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User userLogged(HttpServletRequest request) {
		 HttpSession session=request.getSession();
	     SecurityContext context= (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
	     String username=context.getAuthentication().getName();
	     User user = userdao.findUserByUsername(username);    
	     return user;
	}

}
