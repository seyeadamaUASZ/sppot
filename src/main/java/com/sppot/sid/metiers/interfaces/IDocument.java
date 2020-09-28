package com.sppot.sid.metiers.interfaces;

import java.util.List;

import com.sppot.sid.models.Document;

public interface IDocument {
	
	public List<Document> listdocuments();
	public Document addDocument(Document document);
	public List<Document> listDocumentByKey(String motcles);
	public Document updateDocument(Long id,Document doc);
	public Document getDocument(Long id);

}
