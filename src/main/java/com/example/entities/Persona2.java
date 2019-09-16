package com.example.entities;
// Generated 14-05-2019 09:58:12 by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name = "Persona2")
public class Persona2 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private TipoDocumento tipoDocumento;
	@NotNull
	//@Size(min=2, message="firstName should have atleast 2 characters")
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	

	public Persona2() {
	}

	public Persona2(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Persona2(TipoDocumento tipoDocumento, String firstName, String lastName, String phoneNumber, String email) {
		this.tipoDocumento = tipoDocumento;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TipoDocumentoId", nullable = false)
	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", tipoDocumento=" + tipoDocumento.toString() + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
