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
public class Dongle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_dongle;
	private long numero;

	// attributs du model relationnel

	@ManyToOne
	private Operateur operateur;
	@OneToMany(mappedBy = "dongle")
	private List<Transfert> transferts;

	public int getId_dongle() {
		return id_dongle;
	}

	public void setId_dongle(int id_dongle) {
		this.id_dongle = id_dongle;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_dongle;
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
		Dongle other = (Dongle) obj;
		if (id_dongle != other.id_dongle) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Dongle [numero=" + numero + "]";
	}

}
