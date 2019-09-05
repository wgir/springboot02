package com.example.service;

import java.text.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import com.example.dto.Constantes;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;
import com.example.dto.PersonaDtoValidator;
import com.example.entities.Persona;
import com.example.repository.PersonaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Service
//@EnableJpaRepositories("com.example.repository")
public class PersonaService implements IPersonaService {
	@Autowired
	PersonaRepository dao;

	
	 @Autowired
	 private ModelMapper modelMapper;
	 
	 @Autowired
	 private PersonaDtoValidator validador;
	 
	 
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
		Persona obj=null;
		PersonaDtoResponse respuesta=validarEntidad(objDto);
		if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
	    	try {
	    			obj = this.convertToEntity(objDto);
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
    	Persona obj=null;
    	PersonaDtoResponse respuesta=validarEntidad(objDto);
    	if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
    		try {
    			obj = this.convertToEntity(objDto);
	    		Persona p=dao.findById(id).get();
				if(p!=null)
				{
	    				p.setFirstName(objDto.getFirstName());
	    				p.setLastName(objDto.getLastName());
	    				//p.setTipoDocumento(new TipoDocumento(objDto.getTipoDocumentoId(),""));
	    				p.setEmail(objDto.getEmail());
	    				p.setPhoneNumber(objDto.getPhoneNumber());
	    				respuesta.addPersonaDto(convertToDto(dao.save(obj)));
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
	
    private Persona convertToEntity(PersonaDto objDto) throws ParseException {
	    Persona obj = modelMapper.map(objDto, Persona.class);
	    //obj.setTipoDocumento(new TipoDocumento(objDto.getTipoDocumentoId(),""));
	  
	    return obj;
	}
	
	private PersonaDto convertToDto(Persona obj) {
		PersonaDto objDto = modelMapper.map(obj, PersonaDto.class);
	    return objDto;
	}
	
}
