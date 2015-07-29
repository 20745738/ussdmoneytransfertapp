package com.sifast.ussd.test;

import java.util.List;

import com.sifast.ussd.dao.impl.TransfertDaoImpl;
import com.sifast.ussd.model.Transfert;


public class TestConfiguration {

	public static void main(String[] args) {
		TransfertDaoImpl transfertDao= new TransfertDaoImpl();
		List<Transfert> listTransferts = transfertDao.findAll();
		System.out.print(listTransferts.get(1).toString());

	}

}
