package com.sifast.ussd.dao;

import java.util.List;

import com.sifast.ussd.model.Transfert;

public interface TransfertDao {

	public void addTransfert(Transfert transfert);

	public void deleteTransfert(Transfert transfert);

	public Transfert findById(Transfert transfert);

	public List<Transfert> findAll();

}
