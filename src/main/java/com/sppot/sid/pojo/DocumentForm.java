package com.sppot.sid.pojo;

import java.util.Date;

public class DocumentForm {
	private String fileName;
	private String fileType;
	private String filedownloadURI;
	private Date dateFile;
	private String motcles;
	private String nomCategorie;
	
	
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
	public String getMotcles() {
		return motcles;
	}
	public void setMotcles(String motcles) {
		this.motcles = motcles;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public DocumentForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
