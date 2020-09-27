package com.sppot.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sppot.sid.models.Document;

public interface DocumentDao extends JpaRepository<Document, Long> {

}
