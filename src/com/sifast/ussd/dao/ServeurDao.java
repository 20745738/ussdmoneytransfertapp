package com.sifast.ussd.dao;

import java.util.List;

import com.sifast.ussd.model.Serveur;


public interface ServeurDao {
	public void addServeur(Serveur serveur);
	public void deleteServeur(Serveur serveur);
	public Serveur findById( Serveur serveur);
	public List<Serveur> findAll();
}
