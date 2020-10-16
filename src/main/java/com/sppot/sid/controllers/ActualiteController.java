package com.sppot.sid.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sppot.sid.dao.TypeActualiteDao;
import com.sppot.sid.metiers.interfaces.IActualite;
import com.sppot.sid.metiers.interfaces.IDocument;
import com.sppot.sid.metiers.interfaces.IUser;
import com.sppot.sid.models.Actualite;
import com.sppot.sid.models.Document;
import com.sppot.sid.models.TypeActualite;
import com.sppot.sid.models.User;

@Controller
public class ActualiteController {
	
	@Autowired
  private IActualite iactu;
	
	@Autowired
  private TypeActualiteDao typedao;
	
	@Autowired
  private IUser iuser;
  
	@Autowired
	private IDocument idoc;	
	
	
	
  
	@GetMapping("/actualitead")
  public String actualiteAd(Model model,HttpServletRequest request) {
	List<Actualite> actualites = iactu.listeActualites();
	List<TypeActualite> typeactualites = typedao.findAll();
	User user = iuser.userLogged(request);
	
	model.addAttribute("actualites", actualites);
	model.addAttribute("typeactualites", typeactualites);
	model.addAttribute("user", user);
	return "actualitead";
  }
	
	@RequestMapping(value = "/getactu",method = RequestMethod.GET)
    @ResponseBody
	public Actualite getactu(Long id) {
		return iactu.getActu(id);
	}	
	
	@PostMapping("/saveActu")
	public String addActualite(@Valid Actualite actualite) {
		//System.out.println(actualite.getDatedebut());
		if(actualite.isStatusdoc()) {
			actualite.setStatus("Archivé");
		}else {
			actualite.setStatus("Non archivé");
		}
		iactu.addActualite(actualite);
		return "redirect:/actualitead";
	}
	
	@GetMapping("/actualites")
	public String actualites(Model model) {
		List<Document> documents = idoc.listDocumentsActualites(5L);
		model.addAttribute("documents", documents);
		return "actualites";
	}
	
}
