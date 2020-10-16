package com.sppot.sid.metiers.interfaces;

import java.util.List;

import com.sppot.sid.models.CategorieDocument;

public interface ICategorieDocument {
	
	public List<CategorieDocument> listCategories();
	public CategorieDocument addcategorie(CategorieDocument categorieDocument);
	
	public Integer compteCategories();

}
