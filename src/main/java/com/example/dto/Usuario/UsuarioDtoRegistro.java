package com.example.dto.Usuario;

public class UsuarioDtoRegistro {
	
	private String nombre;
	private String userName; //email
	
 
	public UsuarioDtoRegistro()
	{
		 
	}
	 
	public UsuarioDtoRegistro(String userName, String nombre) {
		super();
		this.userName = userName;
		this.nombre=nombre;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
 
}
