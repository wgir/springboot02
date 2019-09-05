package com.example.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import com.example.dto.Constantes;
import com.example.dto.ContactoDto;
import com.example.dto.ContactoDtoResponse;
import com.example.dto.ContactoDtoValidator;
import com.example.entities.Contacto;
import com.example.repository.ContactoRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Service
//@EnableJpaRepositories("com.example.repository")
public class ContactoService implements IContactoService {
	@Autowired
	ContactoRepository dao;

	@Autowired
	 private ModelMapper modelMapper;
	
	@Autowired
	 private ContactoDtoValidator validador;
	// (3)
	
	public ContactoDtoResponse validarEntidad(ContactoDto objDto)
	 {
			ContactoDtoResponse respuesta=new ContactoDtoResponse(Constantes.ERROR,"");
			BindException result = new BindException(objDto,"contactoDto");
			validador.validate(objDto,result);
	    	if (result.hasErrors()) {
			    respuesta.setEstado(Constantes.ERROR_VALIDACION);
	    		for (ObjectError error : result.getAllErrors()) 
	    			respuesta.setMensaje(respuesta.getMensaje()+error.getDefaultMessage()+";");
	    	}
	    	return respuesta;
	 }
	
	 public ContactoDtoResponse save(ContactoDto objDto){
			Contacto obj=null;
			ContactoDtoResponse respuesta=validarEntidad(objDto);
			if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
	    	{
		    	try {
		    			obj=this.convertToEntity(objDto);
		    			obj=dao.save(obj);
		    			respuesta.setContactoDto(dao.getContactoById(obj.getId()));
		    			respuesta.setEstado(Constantes.OK);
		    		}catch(Exception e){
		    			respuesta.setMensaje(e.getMessage());
		    		}
	    	}
	    	return respuesta;
		}
    
    public ContactoDtoResponse getAll()
    {
    	ContactoDtoResponse respuesta=new ContactoDtoResponse(Constantes.ERROR,"");
    	try {
    		respuesta.setContactoDto(dao.getAll());
    		respuesta.setEstado(Constantes.OK);
		}catch(Exception e){
			respuesta.setMensaje(e.getMessage());
		}
    	return respuesta;
    }
    
	
	@JsonIgnore
	public ContactoDtoResponse get(Long id)
	{
    	ContactoDtoResponse respuesta=new ContactoDtoResponse(Constantes.ERROR,"");
		try {
				respuesta.setContactoDto(dao.getContactoById(id));
				respuesta.setEstado(Constantes.OK);
			}catch(Exception e){
				respuesta.setMensaje(e.getMessage());
			}
		return respuesta;
	}
	
	
	private Contacto convertToEntity(ContactoDto objDto) throws ParseException {
	    Contacto obj = modelMapper.map(objDto, Contacto.class);
	    //obj.setTipoDocumento(new TipoDocumento(objDto.getTipoDocumentoId(),""));
	  
	    return obj;
	}
	
	private ContactoDto convertToDto(Contacto obj) {
		ContactoDto objDto = modelMapper.map(obj, ContactoDto.class);
	    return objDto;
	}

	
}
