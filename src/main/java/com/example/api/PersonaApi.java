package com.example.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.dto.Constantes;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;
import com.example.service.IPersonaService;

//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping(value="/api")
public class PersonaApi {
	
	
	private static final Logger LOG = LogManager.getLogger(PersonaApi.class);

	@Autowired
	IPersonaService service;
	
	
	//@RequestMapping(value="/personas", produces = "application/json",method=RequestMethod.GET)
	//@GetMapping({"/personas", "/personas/{id}"})
	//@ApiOperation(value = "Fetches all persons in the database.", response = PersonaDtoResponse.class)
	@GetMapping({"/personas"})
	public PersonaDtoResponse get() { //@PathVariable(required = false) String id){
		//LOG.info("Id:"+id);
	        return service.getAll();
    }
	 
	//@RequestMapping(value="/persona", method=RequestMethod.POST)
	@PostMapping(path = "/personas", consumes = "application/json", produces = "application/json")
	public PersonaDtoResponse save(@RequestBody PersonaDto personaDto){
	   //System.out.println(personaDto.toString());
		/*LOG.debug("Debugging log in our greeting method");
        LOG.info("Info log in our greeting method");
        LOG.warn("Warning log in our greeting method");
        LOG.error("Error in our greeting method");
        LOG.fatal("Damn! Fatal error. Please fix me.");*/
	   return service.save(personaDto);
	}
	
	
	
	@PutMapping("/personas/{id}")
	public ResponseEntity<PersonaDtoResponse> update(@PathVariable Long id, @RequestBody PersonaDto obj) {

		PersonaDtoResponse respuesta = service.update(id, obj);

		if (respuesta.getPersonaDto().size()==0) {
			return new ResponseEntity<PersonaDtoResponse>(respuesta, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PersonaDtoResponse>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping(value="/personas/{id}", produces = "application/json",method=RequestMethod.GET)
	public ResponseEntity<PersonaDtoResponse> getOne(@PathVariable("id") Long id){
		PersonaDtoResponse respuesta=service.get(id);
		return new ResponseEntity<PersonaDtoResponse>(respuesta, respuesta.getEstado() == Constantes.NOT_FOUND ?  HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
	
	
}
