package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class PerfilDtoResponse extends Respuesta {
	List<PerfilDto> listaDto;
	
	public PerfilDtoResponse(int estado, String mensaje) {
		super(estado, mensaje);
		// TODO Auto-generated constructor stub
		listaDto=new ArrayList<PerfilDto>();
	}

	public List<PerfilDto> getListaDto() {
		return listaDto;
	}

	public void setListaDto(List<PerfilDto> listaDto) {
		this.listaDto = listaDto;
	}
	
	public void addObjToListaDto(PerfilDto objDto)
	{
		this.listaDto.add(objDto);
	}
	
	
	
	

}
