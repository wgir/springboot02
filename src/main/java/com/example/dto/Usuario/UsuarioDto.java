package com.example.dto.Usuario;

import com.example.dto._DTOEntity;

public class UsuarioDto implements _DTOEntity{
	
	private int idUsuario;
	private String userName;
	private String password;
	private boolean activo;
	
 
	public UsuarioDto()
	{
		 
	}
	
	public UsuarioDto(int idUsuario,String userName) 
	{
		this.setIdUsuario(idUsuario);
		this.userName = userName;
	}
	
	public UsuarioDto(String userName, String password) {
		super();
		this.userName = userName;
		this.setPassword(password);
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

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
 
}
