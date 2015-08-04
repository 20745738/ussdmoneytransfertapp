package com.sifast.ussd.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.sifast.ussd.dao.impl.ServeurDaoImpl;
import com.sifast.ussd.model.Serveur;

public class ServeurConverter implements Converter {
	public ServeurConverter() {

	}

	// lors du submit recup de l'objet serveur a partir de l'id
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		if (arg2.equals(""))
			return null;

		int id = Integer.valueOf(arg2);
		Serveur serveur = new ServeurDaoImpl().findById(id);
		return serveur;

	}

	// lors de l'affichage du serveur utilisant l'id en tand que value
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 == null)
			return "";

		Serveur serveur = (Serveur) arg2;
		return String.valueOf(serveur.getId_serveur());
	}
}
