package com.example.dto;
// Generated 14-05-2019 09:58:12 by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contacto generated by hbm2java
 */

public class TipoDocumentoDto implements java.io.Serializable {

	private int id;
	private String glosa;
	

	//public ContactoDto() {	}

	public TipoDocumentoDto(int id,String glosa) {
		this.id=id;
		this.glosa = glosa;
		
		
	}

	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getGlosa() {
		return this.glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
}
