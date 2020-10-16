package com.sppot.sid.metiers.interfaces;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.sppot.sid.models.User;

public interface IUser {
	public List<User> listUser();
	public User addUser(User user);
	public void updateUser(Long id,User useru);
	public boolean deleteUser(Long id);
	public User userLogged(HttpServletRequest request);
	public Integer compteUsers();
	public User getUser(Long id);

}
