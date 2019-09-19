package com.example.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import com.example.constantes.Constantes;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;
import com.example.dto.PersonaDtoValidator;
import com.example.entities.Pers_Persona;
import com.example.repository.PersonaRepository;
import com.example.util.Mapeo;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Service
//@EnableJpaRepositories("com.example.repository")
public class PersonaService implements IPersonaService {
	
	
	@Autowired
	PersonaRepository dao;

	/*
	 @Autowired
	 private ModelMapper modelMapper;
	 */
	 @Autowired
	 private PersonaDtoValidator validador;
	 
	 @Autowired
	 private Mapeo maper;
	 
	 public PersonaDtoResponse validarEntidad(PersonaDto objDto)
	 {
		 	PersonaDtoResponse respuesta=new PersonaDtoResponse(Constantes.ERROR,"");
			BindException result = new BindException(objDto,"personaDto");
			validador.validate(objDto,result);
	    	if (result.hasErrors()) {
			    respuesta.setEstado(Constantes.ERROR_VALIDACION);
	    		for (ObjectError error : result.getAllErrors()) 
	    			respuesta.setMensaje(respuesta.getMensaje()+error.getDefaultMessage()+";");
	    	}
	    	return respuesta;
	 }
	
	 public PersonaDtoResponse save(PersonaDto objDto){
		Pers_Persona obj=new Pers_Persona();
		PersonaDtoResponse respuesta=validarEntidad(objDto);
		if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
	    	try {
	    			obj = (Pers_Persona)maper.convertToEntity(objDto,obj);
	    			obj.setActivo(true);
	    			obj.setCreatedOn(Calendar.getInstance());
	    			obj=dao.save(obj);
	    			respuesta.setListaDto(dao.getPersonaById(obj.getId()));
	    			respuesta.setEstado(Constantes.OK);
	    		}catch(Exception e){
	    			respuesta.setMensaje(e.getMessage());
	    		}
    	}
    	return respuesta;
	}

    
    public PersonaDtoResponse getAll()
    {
    	PersonaDtoResponse respuesta=new PersonaDtoResponse(Constantes.ERROR,"");
    	try {
    		respuesta.setListaDto(dao.getAll());
    		respuesta.setEstado(Constantes.OK);
		}catch(Exception e){
			respuesta.setMensaje(e.getMessage());
		}
    	return respuesta;
    }
    
    @JsonIgnore
	public PersonaDtoResponse get(Long id)
	{
    	PersonaDtoResponse respuesta=new PersonaDtoResponse(Constantes.ERROR,"");
		try {
				respuesta.setListaDto(dao.getPersonaById(id));
				respuesta.setEstado(Constantes.OK);
			}catch(Exception e){
				respuesta.setMensaje(e.getMessage());
			}
		return respuesta;
	}

    @Override
	public PersonaDtoResponse update(Long id, PersonaDto objDto) {
		// TODO Auto-generated method stub
    	Pers_Persona obj=new Pers_Persona();
    	PersonaDtoResponse respuesta=validarEntidad(objDto);
    	if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
    		try {
    			obj = (Pers_Persona) maper.convertToEntity(objDto,obj);
	    		Pers_Persona p=dao.findById(id).get();
				if(p!=null)
				{
	    				p.setDocumento(objDto.getDocumento());
	    				p.setNombres(objDto.getNombres());
	    				p.setApellidos(objDto.getApellidos());
	    				p.setEmail(objDto.getEmail());
	    				p.setSexo(objDto.getSexo());
	    				p.setFechaNacimiento(objDto.getFechaNacimiento());
	    				respuesta.addListaDto((PersonaDto) maper.convertToDto(dao.save(obj),objDto));
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
