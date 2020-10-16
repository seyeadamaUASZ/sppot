package com.sppot.sid.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Actualite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datedebut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datefin;
	
	private String motcles;
	
	private boolean statusdoc;
	private String status;
	
	public boolean isStatusdoc() {
		return statusdoc;
	}
	public void setStatusdoc(boolean statusdoc) {
		this.statusdoc = statusdoc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMotcles() {
		return motcles;
	}
	public void setMotcles(String motcles) {
		this.motcles = motcles;
	}
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne
	private TypeActualite typeactualite;
	
	public TypeActualite getTypeactualite() {
		return typeactualite;
	}
	public void setTypeactualite(TypeActualite typeactualite) {
		this.typeactualite = typeactualite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Actualite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Actualite(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
	}
	
	

	
	
}
