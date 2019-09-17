package com.example.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	
	@Column(name = "userName", length = 50)
	@ColumnPosition(position = 1) 
	private String userName;
	
	@Column(name = "password", length = 50)
	@ColumnPosition(position = 2) 
	private String password;
	
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPerfil", nullable = false)
	private Segu_Perfil segu_perfil;
	
	public Segu_Usuario()
	{
	 
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Segu_Usuario(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
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
		return segu_perfil;
	}
	public void setPerfil(Segu_Perfil segu_perfil) {
		this.segu_perfil = segu_perfil;
	}
 
}
