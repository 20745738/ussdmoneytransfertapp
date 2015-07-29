package com.sifast.ussd.dao;

import java.util.List;

import com.sifast.ussd.model.Operateur;



public interface OperateurDao {
	public void addOperateur(Operateur operateur);
	public void deleteOperateur(Operateur operateur);
	public Operateur findById( Operateur operateur);
	public List<Operateur> findAll();


}
