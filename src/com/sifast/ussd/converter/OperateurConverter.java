package com.sifast.ussd.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.sifast.ussd.dao.impl.OperateurDaoImpl;
import com.sifast.ussd.model.Operateur;

public class OperateurConverter implements Converter {
	public OperateurConverter() {

	}

	// lors du submit recup de l'objet operateur a partir de l'id
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		int id = Integer.valueOf(arg2);
		Operateur operateur = new OperateurDaoImpl().findById(id);
		return operateur;

	}

	// lors de l'affichage de l'operateur utilisant l'id en tand que value
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		Operateur operateur = (Operateur) arg2;

		return String.valueOf(operateur.getId_operateur());
	}

}
