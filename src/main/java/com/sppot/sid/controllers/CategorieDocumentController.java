package com.sppot.sid.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sppot.sid.metiers.interfaces.ICategorieDocument;
import com.sppot.sid.models.CategorieDocument;

@Controller
public class CategorieDocumentController {
	
	@Autowired
	private ICategorieDocument icate;
	
	@Autowired
	private ICategorieDocument icategorie;
	
	
	@GetMapping("/categorie")
	public String categorie(Model model) {
		List<CategorieDocument> categories = icate.listCategories();
		model.addAttribute("categories", categories);
		return "categoriedoc";
	}
	
	@PostMapping("/saveCategorie")
	public String addCategories(@Valid CategorieDocument categorieDocument) {
		icategorie.addcategorie(categorieDocument);
		return "redirect:/categorie";
	}

}
