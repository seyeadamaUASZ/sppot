package com.sppot.sid.metiers.interfaces;

import java.util.List;

import com.sppot.sid.models.Actualite;

public interface IActualite {
	public Actualite addActualite(Actualite actualite);
	public List<Actualite> listeActualites();
	public Actualite getActu(Long id);

}
