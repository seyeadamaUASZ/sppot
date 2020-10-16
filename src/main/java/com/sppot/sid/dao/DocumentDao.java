package com.sppot.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sppot.sid.models.Document;

public interface DocumentDao extends JpaRepository<Document, Long> {
    
	@Query("select d from Document d where d.motcles like:motcles")
	public List<Document> listDocumentByKey(@Param("motcles")String motcles);
	
	@Query("select count(d) from Document d")
	public Integer countDocuments();
	
	@Query("select d from Document d where d.statusdoc=true")
	public List<Document> listedocumentsarchives();
	
	@Query("select d from Document d , CategorieDocument ca where d.categorieDocument.id = ca.id and ca.id=:id")
	public List<Document> listDocumentspublies(@Param("id")Long id);
	
	@Query("select d from Document d, CategorieDocument ca where d.categorieDocument.id=ca.id and ca.id=:id")
	public List<Document> listDocactualites(@Param("id")Long id);
}
