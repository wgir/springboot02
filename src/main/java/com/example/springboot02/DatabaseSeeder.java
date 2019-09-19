package com.example.springboot02;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.*;
import com.example.repository.*;


@Component
public class DatabaseSeeder {
	
	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	Segu_Perfil objPerfil=null;
	
	 @EventListener
	 public void seed(ContextRefreshedEvent event) {
	     System.out.println("Iniciando base de datos");   
		 seedPrimerUsuario();
	     seedPerfilTable();
	    }
	 
	 @Transactional
	 private void seedPrimerUsuario() 
	 {
		 List<Segu_Perfil> lista=perfilRepository.findAll();
		 if(lista.size()==0)
		 {
		 		objPerfil=new Segu_Perfil(0,"Master");
		 		objPerfil.setCreatedOn(Calendar.getInstance());
		 		objPerfil.setActivo(true);
		 		perfilRepository.save(objPerfil);
		 
		 		//if(objPerfil.getIdPerfil()==1)
		 		//	throw new RuntimeException("a proposito");
		 		
		 		Pers_Persona persona=new Pers_Persona(25543430,"William Gustavo","Giraldo Restrepo",
		 				"M","wiliamgustavo@gmail.com",Calendar.getInstance());
		 		persona.setCreatedOn(Calendar.getInstance());
		 		persona.setActivo(true);
		 		personaRepository.save(persona);
		 		
		 		
		 		Segu_Usuario usuario=new Segu_Usuario();
		 		usuario.setUserName(persona.getEmail());
		 		usuario.setPassword(new BCryptPasswordEncoder().encode("196507"));
		 		usuario.setCreatedOn(Calendar.getInstance());
		 		usuario.setActivo(true);
		 		
		 		usuario.setPerfil(objPerfil);
		 		usuario.setPersona(persona);
		 		persona.setUsuario(usuario);
		 		
		 		usuarioRepository.save(usuario);
		 		
		 		//Segu_Usuario obj=new Segu_Usuario(0,"Master");
		 		//perfilRepository.save(obj);
		 	}
	  }
	 
	 private void seedPerfilTable() 
	 {
		 List<Segu_Perfil> lista=perfilRepository.findAll();
		 if(lista.size()==1)
		 {
		 		objPerfil=new Segu_Perfil(0,"Administrador-Master");
		 		objPerfil.setCreatedOn(Calendar.getInstance());
		 		objPerfil.setActivo(true);
		 		perfilRepository.save(objPerfil);
		 		objPerfil=new Segu_Perfil(0,"Administrador");
		 		objPerfil.setCreatedOn(Calendar.getInstance());
		 		objPerfil.setActivo(true);
		 		perfilRepository.save(objPerfil);

		 }
	 }

	


}
