package com.example.springboot02;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.PerfilDto;
import com.example.dto.PerfilDtoResponse;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;
import com.example.dto.Respuesta;
import com.example.dto.TipoDocumentoDto;
import com.example.dto.TipoDocumentoDtoResponse;
import com.example.dto.Usuario.UsuarioDtoRegistro;
import com.example.dto.Usuario.UsuarioDtoResponse;
import com.example.entities.Pers_Persona;
import com.example.repository.PersonaRepository;
import com.example.constantes.Constantes;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBoot02Application.class) 
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Order(value = 4)
public class UsuarioApiTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;

	 @Autowired
	 private PersonaRepository personaRepository;

	 
	 @LocalServerPort
	 private int port;

	 private String getRootUrl() {
	    return "http://localhost:" + port + "/api/usuario";
	 }

	 HttpHeaders headers = new HttpHeaders();
     HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	  
	 @Test
	 public void contextLoads() {
	 }
	
	 @Test
	 public void testGetAll() {
			ResponseEntity<TipoDocumentoDtoResponse> response = restTemplate.getForEntity(getRootUrl(), TipoDocumentoDtoResponse.class);
	        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	 }
	 
	 
	 @Test
	 public void testAddAdministrador() {
		 	//se consultan todos los items
		    //ResponseEntity<PersonaDtoResponse> response = restTemplate.getForEntity("http://localhost:" + port + "/api/personas", PersonaDtoResponse.class);
		 	//List<Pers_Persona> lista=personaRepository.findAll();
		 	//int cant=lista.size()+1;
		 	ResponseEntity<UsuarioDtoResponse> response = restTemplate.getForEntity(getRootUrl() , UsuarioDtoResponse.class);
		 	int cant=response.getBody().getListaDto().size()+1;
		 	UsuarioDtoRegistro obj = new UsuarioDtoRegistro("correo"+Integer.toString(cant)+"@gmail.com","nombre "+Integer.toString(cant));
		 	//se crea un nuevo item con contador+1
		 	
		 	ResponseEntity<Respuesta> responseRegistro = restTemplate.postForEntity(getRootUrl()+"/registrarAdministrador", obj, Respuesta.class);
		    Assert.assertEquals(HttpStatus.OK,responseRegistro.getStatusCode());
	        Assert.assertEquals(Constantes.OK, responseRegistro.getBody().getEstado());
	
	        //se prueba que un correo no valido no pase
		 	obj = new UsuarioDtoRegistro("correo","nombre "+Integer.toString(cant+1));
		 	responseRegistro = restTemplate.postForEntity(getRootUrl()+"/registrarAdministrador", obj, Respuesta.class);
		    Assert.assertEquals(HttpStatus.OK,responseRegistro.getStatusCode());
	        Assert.assertEquals(Constantes.ERROR_VALIDACION, responseRegistro.getBody().getEstado());
	 }
	 
	 /*
	 @Test
	 public void testUpdate() {
		 	ResponseEntity<PerfilDtoResponse> response = restTemplate.getForEntity(getRootUrl(), PerfilDtoResponse.class);
		 	//System.out.println("modified:"+response.getBody().getListaDto().get(0).toString());
		 	PerfilDto obj = response.getBody().getListaDto().get(0);
		 	String modificado=obj.getGlosa()+" modified"; 
		 	obj.setGlosa(modificado);
		 	
		 	response=restTemplate.postForEntity(getRootUrl() + "/update/"+obj.getId(), obj, PerfilDtoResponse.class);
		    
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
		    Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	        Assert.assertEquals(modificado,response.getBody().getListaDto().get(0).getGlosa());
	 }
	*/

}
