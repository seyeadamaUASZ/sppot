package com.sppot.sid.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CategorieDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String namecategorie;
	
	@OneToMany(mappedBy = "categorieDocument")
	private Collection<Document> documents= new ArrayList<Document>();
	
	
	@JsonIgnore
	public Collection<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNamecategorie() {
		return namecategorie;
	}
	public void setNamecategorie(String namecategorie) {
		this.namecategorie = namecategorie;
	}
	public CategorieDocument(String namecategorie) {
		super();
		this.namecategorie = namecategorie;
	}
	
	public CategorieDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
