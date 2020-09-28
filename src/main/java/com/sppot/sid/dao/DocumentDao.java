package com.sppot.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sppot.sid.models.Document;

public interface DocumentDao extends JpaRepository<Document, Long> {
    
	@Query("select d from Document d where d.motcles=:motcles")
	public List<Document> listDocumentByKey(@Param("motcles")String motcles);
}
