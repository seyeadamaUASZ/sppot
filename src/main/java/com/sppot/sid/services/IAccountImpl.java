package com.sppot.sid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppot.sid.dao.RolesDao;
import com.sppot.sid.dao.UserDao;
import com.sppot.sid.models.Roles;
import com.sppot.sid.models.User;

@Service
public class IAccountImpl implements IAccountService {
	@Autowired
    private UserDao userdao;
	
	@Autowired
    private RolesDao rolesDao;
	
	@Override
	public User addRoleToUser(String username, String roleName) {
		User user=userdao.findUserByUsername(username);
        Roles role=rolesDao.findRolesByNom(roleName);
        user.getRoles().add(role);
        userdao.save(user);
        return user;
	}

	@Override
	public void deleteUserRole(String username, String roleName) {
		// TODO Auto-generated method stub
		   User user = userdao.findUserByUsername(username);
		   Roles role = rolesDao.findRolesByNom(roleName);
		   user.getRoles().remove(role);
		   userdao.deleteById(user.getId());
	}

}
