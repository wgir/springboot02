package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonaDtoResponse extends Respuesta {
	List<PersonaDto> personaDto;
	
	public PersonaDtoResponse(int estado, String mensaje) {
		super(estado, mensaje);
		// TODO Auto-generated constructor stub
		personaDto=new ArrayList<PersonaDto>();
	}

	public List<PersonaDto> getPersonaDto() {
		return personaDto;
	}

	public void setPersonaDto(List<PersonaDto> personaDto) {
		this.personaDto = personaDto;
	}
	
	public void addPersonaDto(PersonaDto personaDto)
	{
		this.personaDto.add(personaDto);
	}
	
	
	
	

}
