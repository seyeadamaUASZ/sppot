package com.sppot.sid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import java.io.File;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;

import com.sppot.sid.metiers.interfaces.ICategorieDocument;
import com.sppot.sid.metiers.interfaces.IDocument;
import com.sppot.sid.models.CategorieDocument;
import com.sppot.sid.models.Document;
import com.sppot.sid.services.FileStorageService;

@Controller
public class DocumentController {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private IDocument idoc;
	
	@Autowired
    private FileStorageService fileStorageService;
	
	@Autowired
	private ICategorieDocument icate;
	
	@GetMapping("/document")
	public String documentpage(Model model) {
		List<Document> documents = idoc.listdocuments();
		List<CategorieDocument> categories = icate.listCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("documents", documents);
		return "document";
	}
	
	@PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id, @RequestParam("motcles") String motcles) {
       Document doc= fileStorageService.storeFile(file,id,motcles); 
       return "redirect:/document";
    }
	
	@GetMapping("/checkresult")
	public String resultat(Model model,@RequestParam(name="motcles") String motcles) {
		List<Document> documents = idoc.listDocumentByKey(motcles);
		model.addAttribute("documents", documents);
		model.addAttribute("motcles", motcles);
		return "resultat";
	}
	
	//lire fichier pdf
		@GetMapping(value = "/fichierPdf",produces = MediaType.APPLICATION_PDF_VALUE)
	    @ResponseBody
	    public FileSystemResource getimfile(@RequestParam(name="id") Long id) throws IOException{
			Document document = idoc.getDocument(id);
	        return new FileSystemResource(new File("./uploads/"+document.getFileName()));
	    }
	
	

}
