package com.sifast.ussd.modelController;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sifast.ussd.dao.impl.OperateurDaoImpl;
import com.sifast.ussd.model.Operateur;
import com.sifast.ussd.model.Serveur;

@ManagedBean
@SessionScoped
public class OperateurController {

	private List<Operateur> listOperateurs;

	public List<Operateur> findAllOperators() {
		OperateurDaoImpl operateurDao = new OperateurDaoImpl();
		this.listOperateurs = operateurDao.findAll();
		return listOperateurs;
	}

	public List<Operateur> findOpearatorsByServer(Serveur serveur) {

		OperateurDaoImpl operateurDao = new OperateurDaoImpl();
		this.listOperateurs = (List<Operateur>) operateurDao.findByObject(serveur);
		return listOperateurs;

	}

}
