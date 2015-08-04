package com.sifast.ussd.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sifast.ussd.dao.ServeurDao;
import com.sifast.ussd.model.Serveur;

/*
 @ManagedBean(name = "serveurDao")
 @SessionScoped*/
public class ServeurDaoImpl implements ServeurDao {

	private SessionFactory sessionFactory;
	private Session session;

	public ServeurDaoImpl() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}

	@Override
	public void addServeur(Serveur serveur) {
		session.save(serveur);
		session.beginTransaction().commit();
	}

	@Override
	public void deleteServeur(Serveur serveur) {
		session.delete(serveur);
		session.beginTransaction().commit();

	}

	@Override
	public Serveur findByObject(Serveur serveur) {

		return session.get(Serveur.class, serveur);
	}

	@Override
	public List<Serveur> findAll() {

		return session.createCriteria(Serveur.class).list();
	}

	public List<Serveur> getListServeurs() {

		return session.createCriteria(Serveur.class).list();

	}

	@Override
	public Serveur findById(int id) {

		return session.get(Serveur.class, id);
	}

}
