package com.example.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Constantes;
import com.example.dto.ContactoDto;
import com.example.dto.ContactoDtoResponse;
import com.example.service.IContactoService;

@RestController
@RequestMapping(value="/api")
public class ContactoApi {
	

	@Autowired
	IContactoService service;
	
	@RequestMapping(value="/contactos", produces = "application/json",method=RequestMethod.GET)
	public ContactoDtoResponse get(){
        return service.getAll();
        		
    }
	
	@RequestMapping(value="/contactos", method=RequestMethod.POST)
	public ContactoDtoResponse save(@RequestBody ContactoDto contactoDto){
	     return service.save(contactoDto);
	}
	
	
	
    
	@RequestMapping(value="/contactos/{id}", produces = "application/json",method=RequestMethod.GET)
	public ResponseEntity<ContactoDtoResponse> getOne(@PathVariable("id") Long id){
		ContactoDtoResponse respuesta=service.get(id);
		return new ResponseEntity<ContactoDtoResponse>(respuesta, respuesta.getEstado() == Constantes.NOT_FOUND ?  HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
