package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDtoResponse extends Respuesta {
	List<UsuarioDto> listaDto;
	
	public UsuarioDtoResponse(int estado, String mensaje) {
		super(estado, mensaje);
		// TODO Auto-generated constructor stub
		listaDto=new ArrayList<UsuarioDto>();
	}

	public List<UsuarioDto> getListaDto() {
		return listaDto;
	}

	public void setListaDto(List<UsuarioDto> listaDto) {
		this.listaDto = listaDto;
	}
	
	public void addObjToListaDto(UsuarioDto objDto)
	{
		this.listaDto.add(objDto);
	}
	
	
	
	

}
