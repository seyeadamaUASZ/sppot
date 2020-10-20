package com.sppot.sid.metiers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppot.sid.dao.DocumentDao;
import com.sppot.sid.metiers.interfaces.IDocument;
import com.sppot.sid.models.Document;

@Service
public class DocumentImpl  implements IDocument{
	
	@Autowired
	private DocumentDao documentDao;

	@Override
	public List<Document> listdocuments() {
		// TODO Auto-generated method stub
		return documentDao.findAll();
	}

	@Override
	public Document addDocument(Document document) {
		// TODO Auto-generated method stub
		return documentDao.save(document);
	}

	
	@Override
	public Document updateDocument(Long id, Document doc) {
		// TODO Auto-generated method stub
		doc.setId(id);
		return documentDao.saveAndFlush(doc);
	}

	@Override
	public Document getDocument(Long id) {
		// TODO Auto-generated method stub
		return documentDao.findById(id).get();
	}

	@Override
	public Integer compteDocuments() {
		// TODO Auto-generated method stub
		return documentDao.countDocuments();
	}

	@Override
	public List<Document> listeDocumentsarchives() {
		// TODO Auto-generated method stub
		return documentDao.listedocumentsarchives();
	}

	@Override
	public List<Document> listeDocumentPublie(Long id) {
		// TODO Auto-generated method stub
		return documentDao.listDocumentspublies(id);
	}

	@Override
	public List<Document> listDocumentsActualites(String nameCategorie) {
		// TODO Auto-generated method stub
		return documentDao.listDocactualites(nameCategorie);
	}

	

	
	

	

}
