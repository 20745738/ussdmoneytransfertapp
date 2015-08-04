package com.sifast.ussd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serveur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_serveur;
	private String adresse_ip;
	private String pays;

	@OneToMany(mappedBy = "serveur")
	private List<Transfert> transferts;
	@OneToMany(mappedBy = "serveur")
	private List<Operateur> operateurs;

	public Serveur() {

	}

	public List<Transfert> getTransferts() {
		return transferts;
	}

	public void setTransferts(List<Transfert> transferts) {
		this.transferts = transferts;
	}

	public List<Operateur> getOperateurs() {
		return operateurs;
	}

	public void setOperateurs(List<Operateur> operateurs) {
		this.operateurs = operateurs;
	}

	public int getId_serveur() {
		return id_serveur;
	}

	public void setId_serveur(int id_serveur) {
		this.id_serveur = id_serveur;
	}

	public String getAdresse_ip() {
		return adresse_ip;
	}

	public void setAdresse_ip(String adresse_ip) {
		this.adresse_ip = adresse_ip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_serveur;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Serveur other = (Serveur) obj;
		if (id_serveur != other.id_serveur) {
			return false;
		}
		return true;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return pays;
	}

}
