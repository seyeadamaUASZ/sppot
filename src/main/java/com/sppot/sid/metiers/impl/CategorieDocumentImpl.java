package com.sppot.sid.metiers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppot.sid.dao.CategorieDocumentDao;
import com.sppot.sid.metiers.interfaces.ICategorieDocument;
import com.sppot.sid.models.CategorieDocument;

@Service
public class CategorieDocumentImpl implements ICategorieDocument {
    
	@Autowired
	private CategorieDocumentDao dao;
	
	@Override
	public List<CategorieDocument> listCategories() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public CategorieDocument addcategorie(CategorieDocument categorieDocument) {
		// TODO Auto-generated method stub
		return dao.save(categorieDocument);
	}

}
