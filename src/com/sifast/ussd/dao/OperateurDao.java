package com.sifast.ussd.dao;

import java.util.List;

import com.sifast.ussd.model.Operateur;
import com.sifast.ussd.model.Serveur;

public interface OperateurDao {

	public void addOperateur(Operateur operateur);

	public void deleteOperateur(Operateur operateur);

	public Operateur findById(Operateur operateur);

	public List<Operateur> findAll();

	Operateur findById(int id);

	Operateur findByObject(Serveur serveur);

}
