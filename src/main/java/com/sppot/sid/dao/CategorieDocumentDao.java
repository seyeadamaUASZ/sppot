package com.sppot.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sppot.sid.models.CategorieDocument;

public interface CategorieDocumentDao extends JpaRepository<CategorieDocument, Long> {
  //check Categorie by name
  public CategorieDocument findCategorieDocumentByNamecategorie(String namecategorie);
  
  @Query("select count(c) from CategorieDocument c")
  public Integer compteCategories();
}
