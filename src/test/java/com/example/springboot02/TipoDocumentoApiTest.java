package com.example.springboot02;

import org.junit.Assert;
import org.junit.FixMethodOrder;
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

import com.example.dto.ContactoDtoResponse;
import com.example.dto.TipoDocumentoDto;
import com.example.dto.TipoDocumentoDtoResponse;
import com.example.constantes.Constantes;
import com.example.dto.ContactoDto;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBoot02Application.class) 
//@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Order(value = 0)
public class TipoDocumentoApiTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;

	 @LocalServerPort
	 private int port;

	 private String getRootUrl() {
	    return "http://localhost:" + port + "/api/tipodocumento";
	 }

	 HttpHeaders headers = new HttpHeaders();
     HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	  
	 @Test
	 public void contextLoads() {
	 }
	
	 @Test
	 public void testGetAll() {
			ResponseEntity<TipoDocumentoDtoResponse> response = restTemplate.getForEntity(getRootUrl()+"/tiposdocumentos", TipoDocumentoDtoResponse.class);
	        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	 }
	 
	 
	 @Test
	 public void testAdd() {
		 	ResponseEntity<TipoDocumentoDtoResponse> response = restTemplate.getForEntity(getRootUrl() + "/tiposdocumentos", TipoDocumentoDtoResponse.class);
		 	int cant=response.getBody().getTipoDocumentoDto().size()+1;
		 	TipoDocumentoDto obj = new TipoDocumentoDto((int) 0,"glosa "+Integer.toString(cant));
		 	
		    response = restTemplate.postForEntity(getRootUrl() + "/tiposdocumentos", obj, TipoDocumentoDtoResponse.class);
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	        Assert.assertEquals(obj.getGlosa(),response.getBody().getTipoDocumentoDto().get(0).getGlosa());
	        
	        obj.setId(response.getBody().getTipoDocumentoDto().get(0).getId());
		 	response = restTemplate.getForEntity(getRootUrl() + "/tiposdocumentos/"+obj.getId(), TipoDocumentoDtoResponse.class);
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	       // Assert.assertEquals(Constantes.ERROR_VALIDACION, response.getBody().getEstado());
	        Assert.assertEquals(obj.getGlosa(),response.getBody().getTipoDocumentoDto().get(0).getGlosa());
        
	 }
	

}
