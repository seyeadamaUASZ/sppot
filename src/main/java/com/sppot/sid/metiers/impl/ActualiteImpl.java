package com.sppot.sid.metiers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppot.sid.dao.ActualiteDao;
import com.sppot.sid.metiers.interfaces.IActualite;
import com.sppot.sid.models.Actualite;

@Service
public class ActualiteImpl implements IActualite{
	
	@Autowired
	private ActualiteDao iactu;

	@Override
	public Actualite addActualite(Actualite actualite) {
		// TODO Auto-generated method stub
		return iactu.save(actualite);
	}

	@Override
	public List<Actualite> listeActualites() {
		// TODO Auto-generated method stub
		return iactu.findAll();
	}

	@Override
	public Actualite getActu(Long id) {
		// TODO Auto-generated method stub
		return iactu.findById(id).get();
	}

}
