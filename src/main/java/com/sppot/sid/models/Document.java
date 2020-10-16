package com.sppot.sid.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fileName;
	private String fileType;
	private String filedownloadURI;
	private Date dateFile;
	private String motcles;
	private boolean statusdoc;
	private String status;
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public boolean isStatusdoc() {
		return statusdoc;
	}


	public void setStatusdoc(boolean statusdoc) {
		this.statusdoc = statusdoc;
	}
	@ManyToOne
	private CategorieDocument categorieDocument;
	
	
	public Document(String fileName, String fileType, String filedownloadURI, Date dateFile, String motcles) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.filedownloadURI = filedownloadURI;
		this.dateFile = dateFile;
		this.motcles = motcles;
	}
	
	
	public Document(String fileName, String fileType) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
	}


	public String getMotcles() {
		return motcles;
	}
	public void setMotcles(String motcles) {
		this.motcles = motcles;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFiledownloadURI() {
		return filedownloadURI;
	}
	public void setFiledownloadURI(String filedownloadURI) {
		this.filedownloadURI = filedownloadURI;
	}
	public Date getDateFile() {
		return dateFile;
	}
	public void setDateFile(Date dateFile) {
		this.dateFile = dateFile;
	}
	public CategorieDocument getCategorieDocument() {
		return categorieDocument;
	}
	public void setCategorieDocument(CategorieDocument categorieDocument) {
		this.categorieDocument = categorieDocument;
	}
	public Document(String fileName, String fileType, String filedownloadURI, Date dateFile) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.filedownloadURI = filedownloadURI;
		this.dateFile = dateFile;
	}
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Document(String fileName, String fileType, String filedownloadURI) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.filedownloadURI = filedownloadURI;
	}
	
	
	
	
	

}
