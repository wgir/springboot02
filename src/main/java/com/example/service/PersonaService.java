package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import com.example.constantes.Constantes;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;
import com.example.dto.PersonaDtoValidator;
import com.example.entities.Persona;
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
		Persona obj=new Persona();
		PersonaDtoResponse respuesta=validarEntidad(objDto);
		if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
	    	try {
	    			obj = (Persona)maper.convertToEntity(objDto,obj);
	    			obj=dao.save(obj);
	    			respuesta.setPersonaDto(dao.getPersonaById(obj.getId()));
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
    		respuesta.setPersonaDto(dao.getAll());
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
				respuesta.setPersonaDto(dao.getPersonaById(id));
				respuesta.setEstado(Constantes.OK);
			}catch(Exception e){
				respuesta.setMensaje(e.getMessage());
			}
		return respuesta;
	}

    @Override
	public PersonaDtoResponse update(Long id, PersonaDto objDto) {
		// TODO Auto-generated method stub
    	Persona obj=new Persona();
    	PersonaDtoResponse respuesta=validarEntidad(objDto);
    	if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
    		try {
    			obj = (Persona) maper.convertToEntity(objDto,obj);
	    		Persona p=dao.findById(id).get();
				if(p!=null)
				{
	    				p.setFirstName(objDto.getFirstName());
	    				p.setLastName(objDto.getLastName());
	    				p.setEmail(objDto.getEmail());
	    				p.setPhoneNumber(objDto.getPhoneNumber());
	    				respuesta.addPersonaDto((PersonaDto) maper.convertToDto(dao.save(obj),objDto));
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
