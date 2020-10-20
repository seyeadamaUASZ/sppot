package com.sppot.sid.metiers.interfaces;

import java.util.List;

import com.sppot.sid.models.Document;

public interface IDocument {
	
	public List<Document> listdocuments();
	public Document addDocument(Document document);
	
	public Document updateDocument(Long id,Document doc);
	public Document getDocument(Long id);
	
	public Integer compteDocuments();
	
	public List<Document> listeDocumentsarchives();
	
	public List<Document> listeDocumentPublie(Long id);
	
	public List<Document> listDocumentsActualites(String nameCategorie);

}
