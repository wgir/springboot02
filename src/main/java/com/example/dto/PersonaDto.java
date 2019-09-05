package com.example.dto;

public class PersonaDto {
	private Long id;
	private int tipoDocumentoId;
	private String glosaTipoDocumento;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	
	public PersonaDto(Long id, int tipoDocumentoId, String glosaTipoDocumento, String firstName, String lastName,
			String phoneNumber, String email) {
		super();
		this.id = id;
		this.tipoDocumentoId = tipoDocumentoId;
		this.glosaTipoDocumento = glosaTipoDocumento;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
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
	public int getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	public void setTipoDocumentoId(int tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	public String getGlosaTipoDocumento() {
		return glosaTipoDocumento;
	}
	public void setGlosaTipoDocumento(String glosaTipoDocumento) {
		this.glosaTipoDocumento = glosaTipoDocumento;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
