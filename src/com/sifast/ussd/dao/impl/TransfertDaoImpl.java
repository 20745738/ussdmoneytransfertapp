package com.sifast.ussd.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sifast.ussd.dao.TransfertDao;
import com.sifast.ussd.model.Operateur;
import com.sifast.ussd.model.Transfert;

public class TransfertDaoImpl implements TransfertDao {

	
	

	private SessionFactory sessionFactory;
	private Session session;
	
	public TransfertDaoImpl() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}
	
	@Override
	public void addTransfert(Transfert transfert) {
		session.save(transfert);
		session.beginTransaction().commit();
		
	}

	@Override
	public void deleteTransfert(Transfert transfert) {
		session.delete(transfert);
		session.beginTransaction().commit();
		}

	@Override
	public Transfert findById(Transfert transfert) {
		
		return session.get(Transfert.class, transfert);
	}

	@Override
	public List<Transfert> findAll() {
		
		return session.createCriteria(Transfert.class).list();
	}
	

	public void ajouterTransfert(Transfert transfert) {
		session.beginTransaction();
		session.save(transfert);
		session.getTransaction().commit();
		
	}

	public List<Transfert> recupererTousLesTransferts() {
		
		return session.createCriteria(Transfert.class).list();
	}

}
