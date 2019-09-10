package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoDtoResponse extends Respuesta {
	List<TipoDocumentoDto> listaDto;
	
	public TipoDocumentoDtoResponse(int estado, String mensaje) {
		super(estado, mensaje);
		// TODO Auto-generated constructor stub
		listaDto=new ArrayList<TipoDocumentoDto>();
	}

	public List<TipoDocumentoDto> getTipoDocumentoDto() {
		return listaDto;
	}

	public void setTipoDocumentoDto(List<TipoDocumentoDto> contactoDto) {
		this.listaDto = contactoDto;
	}
	
	public void addTipoDocumentoDto(TipoDocumentoDto contactoDto)
	{
		this.listaDto.add(contactoDto);
	}
	
	
	
	

}
