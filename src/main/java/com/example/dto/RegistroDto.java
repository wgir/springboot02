package com.example.dto;

public class RegistroDto {
	
	private String nombre;
	private String userName;
	
 
	public RegistroDto()
	{
		 
	}
	 
	public RegistroDto(String userName, String nombre) {
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
