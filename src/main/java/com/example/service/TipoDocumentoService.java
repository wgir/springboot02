package com.example.service;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import com.example.constantes.Constantes;
import com.example.dto.TipoDocumentoDto;
import com.example.dto.TipoDocumentoDtoResponse;
import com.example.dto.TipoDocumentoDtoValidator;
import com.example.entities.TipoDocumento;
import com.example.repository.TipoDocumentoRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Service
public class TipoDocumentoService implements ITipoDocumentoService {
	@Autowired
	TipoDocumentoRepository dao;

	@Autowired
	 private ModelMapper modelMapper;
	
	@Autowired
	 private TipoDocumentoDtoValidator validador;
	// (3)
	
	public TipoDocumentoDtoResponse validarEntidad(TipoDocumentoDto objDto)
	 {
			TipoDocumentoDtoResponse respuesta=new TipoDocumentoDtoResponse(Constantes.ERROR,"");
			BindException result = new BindException(objDto,"tipoDocumentoDto");
			validador.validate(objDto,result);
	    	if (result.hasErrors()) {
			    respuesta.setEstado(Constantes.ERROR_VALIDACION);
	    		for (ObjectError error : result.getAllErrors()) 
	    			respuesta.setMensaje(respuesta.getMensaje()+error.getDefaultMessage()+";");
	    	}
	    	return respuesta;
	 }
	
	 public TipoDocumentoDtoResponse save(TipoDocumentoDto objDto){
			TipoDocumento obj=null;
			TipoDocumentoDtoResponse respuesta=validarEntidad(objDto);
			if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
	    	{
		    	try {
		    			obj=this.convertToEntity(objDto);
		    			obj=dao.save(obj);
		    			respuesta.setTipoDocumentoDto(dao.getTipoDocumentoById(obj.getId()));
		    			respuesta.setEstado(Constantes.OK);
		    		}catch(Exception e){
		    			respuesta.setMensaje(e.getMessage());
		    		}
	    	}
	    	return respuesta;
		}
    
    public TipoDocumentoDtoResponse getAll()
    {
    	TipoDocumentoDtoResponse respuesta=new TipoDocumentoDtoResponse(Constantes.ERROR,"");
    	try {
    		respuesta.setTipoDocumentoDto(dao.getAll());
    		respuesta.setEstado(Constantes.OK);
		}catch(Exception e){
			respuesta.setMensaje(e.getMessage());
		}
    	return respuesta;
    }
    
	
	@JsonIgnore
	public TipoDocumentoDtoResponse get(int id)
	{
    	TipoDocumentoDtoResponse respuesta=new TipoDocumentoDtoResponse(Constantes.ERROR,"");
		try {
				respuesta.setTipoDocumentoDto(dao.getTipoDocumentoById(id));
				respuesta.setEstado(Constantes.OK);
			}catch(Exception e){
				respuesta.setMensaje(e.getMessage());
			}
		return respuesta;
	}
	
	
	private TipoDocumento convertToEntity(TipoDocumentoDto objDto) throws ParseException {
		TipoDocumento obj = modelMapper.map(objDto, TipoDocumento.class);
	    //obj.setTipoDocumento(new TipoDocumento(objDto.getTipoDocumentoId(),""));
	  
	    return obj;
	}
	
	private TipoDocumentoDto convertToDto(TipoDocumento obj) {
		TipoDocumentoDto objDto = modelMapper.map(obj, TipoDocumentoDto.class);
	    return objDto;
	}

	
}
