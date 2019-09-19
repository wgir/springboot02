package com.example.service;

import java.text.ParseException;
import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import com.example.constantes.Constantes;
import com.example.dto.*;
import com.example.dto.Usuario.UsuarioDto;
import com.example.dto.Usuario.UsuarioDtoRegistro;
import com.example.dto.Usuario.UsuarioDtoRegistroValidator;
import com.example.dto.Usuario.UsuarioDtoResponse;
import com.example.dto.Usuario.UsuarioDtoValidator;
import com.example.entities.Pers_Persona;
import com.example.entities.Segu_Perfil;
import com.example.entities.Segu_Usuario;
import com.example.repository.*;
import com.example.util.Mapeo;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	PerfilRepository perfilRepository;
	
	 @Autowired
	 private Mapeo maper;
	
	@Autowired
	 private UsuarioDtoValidator validador;
	
	@Autowired
	 private UsuarioDtoRegistroValidator validadorRegistro;
	// (3)
	
	public UsuarioDtoResponse validarEntidad(UsuarioDto objDto)
	 {
			UsuarioDtoResponse respuesta=new UsuarioDtoResponse(Constantes.ERROR,"");
			BindException result = new BindException(objDto,"UsuarioDto");
			validador.validate(objDto,result);
	    	if (result.hasErrors()) {
			    respuesta.setEstado(Constantes.ERROR_VALIDACION);
	    		for (ObjectError error : result.getAllErrors()) 
	    			respuesta.setMensaje(respuesta.getMensaje()+error.getDefaultMessage()+";");
	    	}
	    	return respuesta;
	 }
	
	 public UsuarioDtoResponse save(UsuarioDto objDto){
			Segu_Usuario obj=new Segu_Usuario();
			UsuarioDtoResponse respuesta=validarEntidad(objDto);
			if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
	    	{
		    	try {
		    			obj=(Segu_Usuario) maper.convertToEntity(objDto,obj);
		    			obj.setCreatedOn(Calendar.getInstance());
		    			obj.setActivo(true);
		    			obj=usuarioRepository.save(obj);
		    			respuesta.setListaDto(usuarioRepository.getObjById(obj.getIdUsuario()));
		    			respuesta.setEstado(Constantes.OK);
		    		}catch(Exception e){
		    			respuesta.setMensaje(e.getMessage());
		    		}
	    	}
	    	return respuesta;
		}
    
    public UsuarioDtoResponse getAll()
    {
    	UsuarioDtoResponse respuesta=new UsuarioDtoResponse(Constantes.ERROR,"");
    	try {
    		respuesta.setListaDto(usuarioRepository.getAll());
    		respuesta.setEstado(Constantes.OK);
		}catch(Exception e){
			respuesta.setMensaje(e.getMessage());
		}
    	return respuesta;
    }
    
	
	@JsonIgnore
	public UsuarioDtoResponse getByUserName(String userName)
	{
    	UsuarioDtoResponse respuesta=new UsuarioDtoResponse(Constantes.ERROR,"");
		try {
				respuesta.setListaDto(usuarioRepository.getObjByUserName(userName));
				respuesta.setEstado(Constantes.OK);
			}catch(Exception e){
				respuesta.setMensaje(e.getMessage());
			}
		return respuesta;
	}
	
	
	@Override
	public UsuarioDtoResponse update(int id, UsuarioDto objDto) {
    	objDto.setIdUsuario(id);
    	UsuarioDtoResponse respuesta=validarEntidad(objDto);
    	if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
    		try {
    			Segu_Usuario obj=usuarioRepository.findById(id).get();
				if(obj!=null)
				{
					obj.setUserName(objDto.getUserName());
					obj.setActivo(objDto.isActivo());
					obj.setEditedOn(Calendar.getInstance());
	    			respuesta.addObjToListaDto((UsuarioDto) maper.convertToDto(usuarioRepository.save(obj),objDto));
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

	@Override
	public UsuarioDtoResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public UsuarioDtoResponse validarUsuarioRegistro(UsuarioDtoRegistro objDto)
	 {
			UsuarioDtoResponse respuesta=new UsuarioDtoResponse(Constantes.ERROR,"");
			BindException result = new BindException(objDto,"UsuarioDtoRegistro");
			validadorRegistro.validate(objDto,result);
	    	if (result.hasErrors()) {
			    respuesta.setEstado(Constantes.ERROR_VALIDACION);
	    		for (ObjectError error : result.getAllErrors()) 
	    			respuesta.setMensaje(respuesta.getMensaje()+error.getDefaultMessage()+";");
	    	}
	    	return respuesta;
	 }
	
	@Override
	public Respuesta registrarAdministrador(UsuarioDtoRegistro objDto) {
		// TODO Auto-generated method stub
		Respuesta respuesta=validarUsuarioRegistro(objDto);
		if(respuesta.getEstado()!=Constantes.ERROR_VALIDACION)
    	{
			Pers_Persona persona=new Pers_Persona(null,objDto.getNombre(),	null,null,objDto.getUserName(), Calendar.getInstance());
	 		persona.setCreatedOn(Calendar.getInstance());
	 		persona.setActivo(true);
	 		personaRepository.save(persona);
	 		
	 		Segu_Usuario usuario=new Segu_Usuario();
	 		usuario.setUserName(persona.getEmail());
	 		String passwd=String.valueOf(getRandomIntegerBetweenRange(9999,100000));
	 		usuario.setPassword(new BCryptPasswordEncoder().encode(passwd));
	 		usuario.setCreatedOn(Calendar.getInstance());
	 		usuario.setActivo(true);
	 		//Segu_Perfil perfil=perfilRepository.getOne(Constantes.PERFIL_ADMINISTRADOR);
	 		Segu_Perfil perfil=new Segu_Perfil(Constantes.PERFIL_ADMINISTRADOR,"");
	 		
	 		usuario.setPerfil(perfil);
	 		usuario.setPersona(persona);
	 		persona.setUsuario(usuario);
	 		
	 		usuarioRepository.save(usuario);
	 		respuesta.setMensaje("Usuario registrado, se enviara un correo con las credenciales de acceso al sistema");
	 		respuesta.setEstado(Constantes.OK);
    	}
		return respuesta;
	}

	
	public static int getRandomIntegerBetweenRange(int min, int max){
	    int x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
}
