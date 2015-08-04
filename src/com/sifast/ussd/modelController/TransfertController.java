package com.sifast.ussd.modelController;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.sifast.ussd.dao.impl.TransfertDaoImpl;
import com.sifast.ussd.model.Transfert;

@ManagedBean
@ApplicationScoped
public class TransfertController {

	private Transfert transfert = new Transfert();
	private List<Transfert> listTransferts;

	public String ajouter() {

		TransfertDaoImpl transfertDao = new TransfertDaoImpl();
		transfertDao.ajouterTransfert(this.transfert);
		System.out.print(this.transfert.getOperateur() + " serv  " + this.transfert.getServeur());

		// redirect to liste.xhtml
		return "listeTransfertsAvance";

	}

	public List<Transfert> getListTransferts() {
		TransfertDaoImpl transfertDao = new TransfertDaoImpl();
		this.listTransferts = transfertDao.recupererTousLesTransferts();
		return listTransferts;
	}

	public Transfert getTransfert() {
		return this.transfert;
	}

	public void setTransfert(Transfert transfert) {
		this.transfert = transfert;
	}

}
