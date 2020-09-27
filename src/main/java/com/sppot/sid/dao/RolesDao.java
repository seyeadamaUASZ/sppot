package com.sppot.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sppot.sid.models.Roles;

public interface RolesDao extends JpaRepository<Roles, Long>{
   public Roles findRolesByNom(String nom);
   
}
