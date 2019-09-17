package com.example.springboot02;

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
import com.example.dto.TipoDocumentoDto;
import com.example.dto.TipoDocumentoDtoResponse;
import com.example.constantes.Constantes;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBoot02Application.class) 
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Order(value = 4)
public class PerfilApiTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;

	 @LocalServerPort
	 private int port;

	 private String getRootUrl() {
	    return "http://localhost:" + port + "/api/perfil";
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
	 public void testAdd() {
		 	//se consultan todos los items
		 	ResponseEntity<PerfilDtoResponse> response = restTemplate.getForEntity(getRootUrl() , PerfilDtoResponse.class);
		 	int cant=response.getBody().getListaDto().size()+1;
		 	PerfilDto obj = new PerfilDto(0,"glosa "+Integer.toString(cant),true);
		 	//se crea un nuevo item con contador+1
		    response = restTemplate.postForEntity(getRootUrl(), obj, PerfilDtoResponse.class);
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	        Assert.assertEquals(obj.getGlosa(),response.getBody().getListaDto().get(0).getGlosa());
	        //se consulta el utlimo iten ingresado
	        obj.setId(response.getBody().getListaDto().get(0).getId());
		 	response = restTemplate.getForEntity(getRootUrl()+"/"+obj.getId(), PerfilDtoResponse.class);
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
		    //se valida que el ultimo item ingresado sea el mismo que se envio
	        Assert.assertEquals(obj.getGlosa(),response.getBody().getListaDto().get(0).getGlosa());
        
	 }
	 
	 
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
	

}
