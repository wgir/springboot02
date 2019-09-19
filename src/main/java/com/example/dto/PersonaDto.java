package com.example.dto;

import java.util.Calendar;

public class PersonaDto implements _DTOEntity {
	private Long id=(long) 0;
	private Integer documento;
	private String nombres;
	private String apellidos;
	private String sexo;
	private String email;
	private Calendar fechaNacimiento;
	
	
	public PersonaDto(Long id, Integer documento, String nombres, String apellidos,String sexo,
			String email, Calendar fechaNacimiento) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.email = email;
		if(fechaNacimiento!=null)
			this.fechaNacimiento=fechaNacimiento;
	}
	
	public PersonaDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}
	
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
