package com.sppot.sid.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sppot.sid.metiers.interfaces.ICategorieDocument;
import com.sppot.sid.metiers.interfaces.IDocument;
import com.sppot.sid.metiers.interfaces.IUser;
import com.sppot.sid.models.User;

@Controller
public class HomeController {
	
	@Autowired
	private IUser iuser;
	@Autowired
	private IDocument idocument;
	@Autowired
	private ICategorieDocument icategorie;
    
	@GetMapping("/")
	public String home(Model model, HttpServletRequest request) {
		User user = iuser.userLogged(request);
		boolean logged=false;
	
		if(user!=null) {
			logged=true;
		}else {
		  logged=false;	
		}
		model.addAttribute("logged", logged);
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin")
    public String administrateur(Model model,HttpServletRequest request) {
		Integer countCategories = icategorie.compteCategories();
		Integer countUsers = iuser.compteUsers();
		Integer countDocuments = idocument.compteDocuments();
		User user = iuser.userLogged(request);
		
		model.addAttribute("countCategories", countCategories);
		model.addAttribute("countUsers", countUsers);
		model.addAttribute("countDocuments", countDocuments);
		model.addAttribute("user", user);
    	return "admin";
    }
	
	
}
