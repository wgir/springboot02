package com.example.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.constantes.Constantes;
import com.example.dto.TipoDocumentoDto;
import com.example.dto.TipoDocumentoDtoResponse;
import com.example.service.ITipoDocumentoService;


@RestController
@RequestMapping(value="/api/tipodocumento")
public class TipoDocumentoApi {
	

	@Autowired
	ITipoDocumentoService service;
	
	
	@RequestMapping(value="/tiposdocumentos", produces = "application/json",method=RequestMethod.GET)
	public TipoDocumentoDtoResponse get(){
        return service.getAll();
        		
    }
	
	@RequestMapping(value="/tiposdocumentos", method=RequestMethod.POST)
	public TipoDocumentoDtoResponse save(@RequestBody TipoDocumentoDto objDto){
	     return service.save(objDto);
	}
	
	
	
    
	@RequestMapping(value="/tiposdocumentos/{id}", produces = "application/json",method=RequestMethod.GET)
	public ResponseEntity<TipoDocumentoDtoResponse> getOne(@PathVariable("id") int id){
		TipoDocumentoDtoResponse respuesta=service.get(id);
		return new ResponseEntity<TipoDocumentoDtoResponse>(respuesta, respuesta.getEstado() == Constantes.NOT_FOUND ?  HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
