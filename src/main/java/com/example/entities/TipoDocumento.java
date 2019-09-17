package com.example.entities;
// Generated 14-05-2019 09:58:12 by Hibernate Tools 5.1.10.Final

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Customizer;

import com.example.config.ColumnPosition;
import com.example.config.EntityColumnPositionCustomizer;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * TipoDocumento generated by hbm2java
 */
@Entity
@Table(name = "TipoDocumento")
@Customizer(EntityColumnPositionCustomizer.class)
public class TipoDocumento extends _BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	@ColumnPosition(position = 0) 
	private Long id;
	
	
	@Column(name = "glosa", length = 50)
	@ColumnPosition(position = 1) 
	private String glosa;
	
	/*
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDocumento")
	private Set<Persona2> personas = new HashSet<Persona2>(0);
	*/
    /*	
    @Column(name = "createdon")
    private Calendar createdOn;
    */
	public TipoDocumento() {
	}

	
/*
	public TipoDocumento(String glosa, Set<Persona2> personas) {
		this.glosa = glosa;
		this.personas = personas;
	}
	*/
	
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getGlosa() {
		return this.glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
	
	   
	/*
	public Set<Persona2> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona2> personas) {
		this.personas = personas;
	}
*/
	@Override
	public String toString() {
		return "TipoDocumento [id=" + this.getId() + ", glosa=" + glosa + "]";
	}
	
	

	

}
