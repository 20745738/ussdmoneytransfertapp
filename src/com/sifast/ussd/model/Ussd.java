package com.sifast.ussd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ussd implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_ussd;
	private Date date;
	private String code_ussd;
	@ManyToOne
	private Transfert transfert;

	/*
	 * Exemple type={"REQUEST","RESPONSE3}
	 */
	private String type;

	public int getId() {
		return id_ussd;
	}

	public void setId(int id) {
		this.id_ussd = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode_ussd() {
		return code_ussd;
	}

	public void setCode_ussd(String code_ussd) {
		this.code_ussd = code_ussd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
