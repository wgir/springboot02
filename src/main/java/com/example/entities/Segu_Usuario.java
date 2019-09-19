package com.example.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Customizer;

import com.example.config.ColumnPosition;
import com.example.config.EntityColumnPositionCustomizer;

@Entity
@Table(name = "segu_usuario")
@Customizer(EntityColumnPositionCustomizer.class)

public class Segu_Usuario extends _BaseEntity{
 
 
 	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUsuario", unique = true, nullable = false)
	@ColumnPosition(position = 0) 
	private int idUsuario;
	
 	
 	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPersona", nullable = false)
	private Pers_Persona persona;
 	
 	
	@Column(name = "userName", length = 100)
	@ColumnPosition(position = 1) 
	private String userName;
	
	@Column(name = "password", length = 500)
	@ColumnPosition(position = 2) 
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPerfil", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JoinColumn(name = "idPerfil", nullable = false)
	private Segu_Perfil perfil;
	
	public Segu_Usuario()
	{
	 
	}
	
	public Segu_Usuario(String userName, String password) 
	{
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public Pers_Persona getPersona() {
		return persona;
	}
	public void setPersona(Pers_Persona persona) {
		this.persona = persona;
	}
	
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Segu_Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Segu_Perfil perfil) {
		this.perfil = perfil;
	}
 
}
