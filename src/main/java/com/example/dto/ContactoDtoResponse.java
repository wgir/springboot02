package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class ContactoDtoResponse extends Respuesta {
	List<ContactoDto> contactoDto;
	
	public ContactoDtoResponse(int estado, String mensaje) {
		super(estado, mensaje);
		// TODO Auto-generated constructor stub
		contactoDto=new ArrayList<ContactoDto>();
	}

	public List<ContactoDto> getContactoDto() {
		return contactoDto;
	}

	public void setContactoDto(List<ContactoDto> contactoDto) {
		this.contactoDto = contactoDto;
	}
	
	public void addContactoDto(ContactoDto contactoDto)
	{
		this.contactoDto.add(contactoDto);
	}
	
	
	
	

}
