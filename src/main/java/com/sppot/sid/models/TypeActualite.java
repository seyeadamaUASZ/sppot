package com.sppot.sid.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TypeActualite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String typeActu;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeActu() {
		return typeActu;
	}
	public void setTypeActu(String typeActu) {
		this.typeActu = typeActu;
	}
	
	public TypeActualite(String typeActu) {
		super();
		this.typeActu = typeActu;
	}
	
	@OneToMany(mappedBy = "typeactualite")
	private Collection<Actualite> actualites = new ArrayList<Actualite>();


	@JsonIgnore
	public Collection<Actualite> getActualites() {
		return actualites;
	}
	
	public void setActualites(Collection<Actualite> actualites) {
		this.actualites = actualites;
	}
	public TypeActualite() {
		super();
	}
	
	
	
	
}
