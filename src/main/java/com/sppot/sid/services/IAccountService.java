package com.sppot.sid.services;

import com.sppot.sid.models.User;

public interface IAccountService {
	public User addRoleToUser(String username, String roleName);
    public void deleteUserRole(String username,String roleName);
}
