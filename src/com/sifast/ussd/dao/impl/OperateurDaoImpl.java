package com.sifast.ussd.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sifast.ussd.dao.OperateurDao;
import com.sifast.ussd.model.Operateur;

public class OperateurDaoImpl implements OperateurDao {
	


	private SessionFactory sessionFactory;
	private Session session;
	
	public OperateurDaoImpl() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}

	@Override
	public void addOperateur(Operateur operateur) {
		
		session.save(operateur);
		session.beginTransaction().commit();
		
	}

	@Override
	public void deleteOperateur(Operateur operateur) {
		
		session.delete(operateur);
		session.beginTransaction().commit();

	}

	@Override
	public Operateur findById(Operateur operateur) {
		
		return session.get(Operateur.class, operateur);
	
	}

	@Override
	public List<Operateur> findAll() {
		
		return session.createCriteria(Operateur.class).list();
	
	}

}
