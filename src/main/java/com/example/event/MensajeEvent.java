package com.example.event;

import java.io.Serializable;

public class MensajeEvent implements Serializable{
	private int Id;
	private String mensaje;
	
	
	public MensajeEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MensajeEvent(int id, String mensaje) {
		super();
		Id = id;
		this.mensaje = mensaje;
	}


	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	

}
