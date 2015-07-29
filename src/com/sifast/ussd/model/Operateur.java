package com.sifast.ussd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Operateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_operateur;

	private String code_ussd;
	@ManyToOne
	private Serveur server;

	@OneToMany(mappedBy = "operateur")
	private List<Dongle> dongles;

	public int getId_operateur() {
		return id_operateur;
	}

	public void setId_operateur(int id_operateur) {
		this.id_operateur = id_operateur;
	}

	public String getCode_ussd() {
		return code_ussd;
	}

	public void setCode_ussd(String code_ussd) {
		this.code_ussd = code_ussd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_operateur;
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
		Operateur other = (Operateur) obj;
		if (id_operateur != other.id_operateur) {
			return false;
		}
		return true;
	}

}
