package com.example.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.constantes.Constantes;
import com.example.dto.Respuesta;
import com.example.dto.Usuario.*;
import com.example.service.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api/usuario")
@Api(value = "Usuario CRUD")
public class UsuarioApi {
	
	@Autowired
	UsuarioService service;
	
	@ApiOperation(value = "getAll", notes = "Return all perfils" )
	@RequestMapping(produces = "application/json",method=RequestMethod.GET)
	public UsuarioDtoResponse get(){
        return service.getAll();
        		
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public UsuarioDtoResponse save(@RequestBody UsuarioDto objDto){
	     return service.save(objDto);
	}
	
	@RequestMapping(value="/registrarAdministrador",method=RequestMethod.POST)
	public Respuesta registrarAdministrador(@RequestBody UsuarioDtoRegistro objDto){
	     return service.registrarAdministrador(objDto);
	}
	@RequestMapping(value="/{id}", produces = "application/json",method=RequestMethod.GET)
	public ResponseEntity<UsuarioDtoResponse> getOne(@PathVariable("id") int id){
		UsuarioDtoResponse respuesta=service.getById(id);
		return new ResponseEntity<UsuarioDtoResponse>(respuesta, respuesta.getEstado() == Constantes.NOT_FOUND ?  HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public ResponseEntity<UsuarioDtoResponse> update(@PathVariable int id, @RequestBody UsuarioDto obj) {

		UsuarioDtoResponse respuesta = service.update(id, obj);

		if (respuesta.getListaDto().size()==0) {
			return new ResponseEntity<UsuarioDtoResponse>(respuesta, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UsuarioDtoResponse>(respuesta, HttpStatus.OK);
	}
}
