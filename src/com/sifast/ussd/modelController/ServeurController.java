package com.sifast.ussd.modelController;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.sifast.ussd.dao.impl.ServeurDaoImpl;
import com.sifast.ussd.model.Serveur;

@ManagedBean
@SessionScoped
public class ServeurController {

	@ManagedProperty(value = "#{operateurController}")
	private OperateurController operateurController;

	List<Serveur> listServeurs;

	public List<Serveur> findAllServers() {

		ServeurDaoImpl serveurDao = new ServeurDaoImpl();

		this.listServeurs = serveurDao.getListServeurs();
		System.out.print(listServeurs.get(1).getId_serveur());
		return listServeurs;
	}

	public OperateurController getOperateurController() {
		return operateurController;
	}

	public void setOperateurController(OperateurController operateurController) {
		this.operateurController = operateurController;
	}

}
