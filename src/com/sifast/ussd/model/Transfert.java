package com.sifast.ussd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Transfert implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_transfert;
	private long numero_emetteur;
	private long numero_recepteur;

	@Column(nullable = true)
	private double montant;
	/*
	 * Exemple statut = {"SUCCES","ECHEC","EN ATTENTE"}
	 */

	private String statut = "statut";

	// attributs du model relationnel
	@ManyToOne
	private Serveur serveur;
	@ManyToOne
	private Dongle dongle;
	@ManyToOne
	private Operateur operateur;
	@OneToMany(mappedBy = "transfert")
	private List<Ussd> ussds;

	public int getId_transfert() {
		return id_transfert;
	}

	public void setId_transfert(int id_transfert) {
		this.id_transfert = id_transfert;
	}

	public Dongle getDongle() {
		return dongle;
	}

	public void setDongle(Dongle dongle) {
		this.dongle = dongle;
	}

	public Operateur getOperateur() {
		return operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}

	public List<Ussd> getUssds() {
		return ussds;
	}

	public void setUssds(List<Ussd> ussds) {
		this.ussds = ussds;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public long getNumero_emetteur() {
		return numero_emetteur;
	}

	public void setNumero_emetteur(long numero_emetteur) {
		this.numero_emetteur = numero_emetteur;
	}

	public long getNumero_recepteur() {
		return numero_recepteur;
	}

	public void setNumero_recepteur(long numero_recepteur) {
		this.numero_recepteur = numero_recepteur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_transfert;
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
		Transfert other = (Transfert) obj;
		if (id_transfert != other.id_transfert) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return statut;
	}

	public Serveur getServeur() {
		return serveur;
	}

	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}
