package com.example.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.constantes.Constantes;
import com.example.dto.PerfilDto;
import com.example.dto.PerfilDtoResponse;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;
import com.example.service.IPerfilService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api/perfil")
@Api(value = "Perfil CRUD")
public class PerfilApi {
	
	/*
	@ApiOperation(value="get perfil",response=Customer.class)
    @ApiResponses(value={
    @ApiResponse(code=200,message="Customer Details Retrieved",response=Customer.class),
   @ApiResponse(code=500,message="Internal Server Error"),
   @ApiResponse(code=404,message="Customer not found")
})*/
	

	@Autowired
	IPerfilService service;
	
	@ApiOperation(value = "getAll", notes = "Return all perfils" )
	@RequestMapping(produces = "application/json",method=RequestMethod.GET)
	public PerfilDtoResponse get(){
        return service.getAll();
        		
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public PerfilDtoResponse save(@RequestBody PerfilDto objDto){
	     return service.save(objDto);
	}
	
	@RequestMapping(value="/{id}", produces = "application/json",method=RequestMethod.GET)
	public ResponseEntity<PerfilDtoResponse> getOne(@PathVariable("id") int id){
		PerfilDtoResponse respuesta=service.getById(id);
		return new ResponseEntity<PerfilDtoResponse>(respuesta, respuesta.getEstado() == Constantes.NOT_FOUND ?  HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	//@PutMapping("/{id}")
	public ResponseEntity<PerfilDtoResponse> update(@PathVariable int id, @RequestBody PerfilDto obj) {

		PerfilDtoResponse respuesta = service.update(id, obj);

		if (respuesta.getListaDto().size()==0) {
			return new ResponseEntity<PerfilDtoResponse>(respuesta, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PerfilDtoResponse>(respuesta, HttpStatus.OK);
	}
}
