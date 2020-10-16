package com.sppot.sid.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String allUsers(Model model,HttpServletRequest request) {
		User user = iuser.userLogged(request);
		model.addAttribute("users", iuser.listUser());
		model.addAttribute("user", user);
		return "user";
	}
	
	@RequestMapping(value = "/getuser",method = RequestMethod.GET)
    @ResponseBody
	public User getUser(Long id) {
		return iuser.getUser(id);
	}
	
	@PostMapping("/saveUser")
	public String saveUser(Model model,@Valid UserForm userForm,RedirectAttributes attributes) {
		User user = new User();
		
		 if(userForm.getId()==null) {
			String password="passer123";
			String passH = encoder.encode(password);
			user.setEmail(userForm.getEmail());
			user.setPassword(passH);
			user.setNom(userForm.getNom());
			user.setPrenom(userForm.getPrenom());
			user.setUsername(userForm.getUsername());
			iuser.addUser(user);	
		}else {
			String password="passer123";
			String passH = encoder.encode(password);
			user.setEmail(userForm.getEmail());
			user.setPassword(passH);
			user.setNom(userForm.getNom());
			user.setPrenom(userForm.getPrenom());
			user.setUsername(userForm.getUsername());	
		    iuser.updateUser(userForm.getId(), user);  
		}
		 Roles  roles= rolesdao.findRolesByNom(userForm.getNomRole());
		 iaccountService.addRoleToUser(userForm.getUsername(), roles.getNom());	 
		return "redirect:/users";
	}

}
