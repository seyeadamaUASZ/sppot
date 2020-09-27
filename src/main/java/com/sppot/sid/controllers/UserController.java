package com.sppot.sid.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sppot.sid.dao.RolesDao;
import com.sppot.sid.metiers.interfaces.IUser;
import com.sppot.sid.models.Roles;
import com.sppot.sid.models.User;
import com.sppot.sid.pojo.UserForm;
import com.sppot.sid.services.IAccountService;

@Controller
public class UserController {
	@Autowired
	private IUser iuser;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private RolesDao rolesdao;
	
	@Autowired
	private IAccountService iaccountService;
	
	@GetMapping("/users")
	public String allUsers(Model model) {
		model.addAttribute("users", iuser.listUser());
		return "user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(Model model,@Valid UserForm userForm,RedirectAttributes attributes) {
		
		String password="passer123";
		String passH = encoder.encode(password);
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setPassword(passH);
		user.setNom(userForm.getNom());
		user.setPrenom(userForm.getPrenom());
		user.setUsername(userForm.getUsername());
		iuser.addUser(user);
		Roles  roles= rolesdao.findRolesByNom(userForm.getNomRole());
		iaccountService.addRoleToUser(userForm.getUsername(), roles.getNom());
		return "redirect:/users";
	}

}
