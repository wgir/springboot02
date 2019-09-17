package com.example.service;

import java.text.ParseException;
import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import com.example.constantes.Constantes;
import com.example.dto.PerfilDto;
import com.example.dto.PerfilDtoResponse;
import com.example.dto.PerfilDtoValidator;
import com.example.entities.Contacto;
import com.example.entities.Segu_Perfil;
import com.example.repository.*;
import com.example.util.Mapeo;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Service
public class PerfilService implements IPerfilService {
	@Autowired
	PerfilRepository dao;

	 @Autowired
	 private Mapeo maper;
	
	@Autowired
	 private PerfilDtoValidator validador;
	// (3)
	
	public PerfilDtoResponse validarEntidad(PerfilDto objDto)
	 {
			PerfilDtoResponse respuesta=new PerfilDtoResponse(Constantes.ERROR,"");
			BindException result = new BindException(objDto,"PerfilDto");
			validador.validate(objDto,result);
	    	if (result.hasErrors()) {
			    respuesta.setEstado(Constantes.ERROR_VALIDACION);
	    		for (ObjectError error : result.getAllErrors()) 
	    			respuesta.setMensaje(respuesta.getMensaje()+error.getDefaultMessage()+";");
	    	}
	    	return respuesta;
	 }
	
	 public PerfilDtoResponse save(PerfilDto objDto){
			Segu_Perfil obj=new Segu_Perfil();
			PerfilDtoResponse respuesta=validarEntidad(objDto);
			if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
	    	{
		    	try {
		    			obj=(Segu_Perfil) maper.convertToEntity(objDto,obj);
		    			obj.setCreatedOn(Calendar.getInstance());
		    			obj.setActivo(true);
		    			obj=dao.save(obj);
		    			respuesta.setListaDto(dao.getObjById(obj.getIdPerfil()));
		    			respuesta.setEstado(Constantes.OK);
		    		}catch(Exception e){
		    			respuesta.setMensaje(e.getMessage());
		    		}
	    	}
	    	return respuesta;
		}
    
    public PerfilDtoResponse getAll()
    {
    	PerfilDtoResponse respuesta=new PerfilDtoResponse(Constantes.ERROR,"");
    	try {
    		respuesta.setListaDto(dao.getAll());
    		respuesta.setEstado(Constantes.OK);
		}catch(Exception e){
			respuesta.setMensaje(e.getMessage());
		}
    	return respuesta;
    }
    
	
	@JsonIgnore
	public PerfilDtoResponse getById(int id)
	{
    	PerfilDtoResponse respuesta=new PerfilDtoResponse(Constantes.ERROR,"");
		try {
				respuesta.setListaDto(dao.getObjById(id));
				respuesta.setEstado(Constantes.OK);
			}catch(Exception e){
				respuesta.setMensaje(e.getMessage());
			}
		return respuesta;
	}
	
	
	@Override
	public PerfilDtoResponse update(int id, PerfilDto objDto) {
    	//Segu_Perfil obj=new Segu_Perfil();
    	objDto.setId(id);
    	PerfilDtoResponse respuesta=validarEntidad(objDto);
    	if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
    		try {
    			//obj = (Segu_Perfil) maper.convertToEntity(objDto,obj);
    			Segu_Perfil obj=dao.findById(id).get();
				if(obj!=null)
				{
					obj.setGlosa(objDto.getGlosa());
					obj.setActivo(objDto.isActivo());
					obj.setEditedOn(Calendar.getInstance());
	    			respuesta.addObjToListaDto((PerfilDto) maper.convertToDto(dao.save(obj),objDto));
		    		respuesta.setEstado(Constantes.OK);	
				}else
					{
						respuesta.setEstado(Constantes.ERROR_VALIDACION);
						respuesta.setMensaje("Id no encontrado:"+id);
					}
				
	    		}catch(Exception e){
	    			respuesta.setMensaje(e.getMessage());
	    		}
			
	
    	}
    	return respuesta;
    	
		
	}
		
}
