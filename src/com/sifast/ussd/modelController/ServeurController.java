package com.sifast.ussd.modelController;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.sifast.ussd.dao.impl.ServeurDaoImpl;
import com.sifast.ussd.model.Serveur;

@ManagedBean
public class ServeurController {
	List<Serveur> listServeurs;

	private List<Serveur> findAllServers() {
		ServeurDaoImpl serveurDao = new ServeurDaoImpl();
		this.listServeurs = serveurDao.getListServeurs();
		return listServeurs;

	}
}
