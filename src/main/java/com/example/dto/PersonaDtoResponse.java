package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonaDtoResponse extends Respuesta {
	List<PersonaDto> listaDto;
	
	public PersonaDtoResponse(int estado, String mensaje) {
		super(estado, mensaje);
		// TODO Auto-generated constructor stub
		listaDto=new ArrayList<PersonaDto>();
	}

	public List<PersonaDto> getListaDto() {
		return listaDto;
	}

	public void setListaDto(List<PersonaDto> personaDto) {
		this.listaDto = personaDto;
	}
	
	public void addListaDto(PersonaDto personaDto)
	{
		this.listaDto.add(personaDto);
	}
	
	
	
	

}
