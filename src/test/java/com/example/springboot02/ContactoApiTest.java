package com.example.springboot02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.Constantes;
import com.example.dto.ContactoDtoResponse;
import com.example.dto.ContactoDto;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBoot02Application.class) 
//@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContactoApiTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;

	 @LocalServerPort
	 private int port;

	 private String getRootUrl() {
	    return "http://localhost:" + port + "/api/";
	 }

	 HttpHeaders headers = new HttpHeaders();
     HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	  
	 @Test
	 public void contextLoads() {
	 }
	
	 @Test
	 public void testGetAllContacts() {
			ResponseEntity<ContactoDtoResponse> response = restTemplate.getForEntity(getRootUrl()+"/contactos", ContactoDtoResponse.class);
	        //ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/personas",HttpMethod.GET, entity, String.class);
	        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	 }
	 
	 
	 @Test
	 public void testAddContacto() {
		 	ResponseEntity<ContactoDtoResponse> response = restTemplate.getForEntity(getRootUrl() + "/contactos", ContactoDtoResponse.class);
		 	int cant=response.getBody().getContactoDto().size()+1;
		 	ContactoDto obj = new ContactoDto((long) 0,Integer.toString(cant),"nombre "+Integer.toString(cant),"apellido "+Integer.toString(cant));
		 	
		    response = restTemplate.postForEntity(getRootUrl() + "/contactos", obj, ContactoDtoResponse.class);
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	        Assert.assertEquals(obj.getFirstName(),response.getBody().getContactoDto().get(0).getFirstName());
	        
	        
		 	obj.setDocumento(Integer.toString(cant));
		 	obj.setFirstName("nombre "+Integer.toString(cant));
		 	obj.setLastName("apellido "+Integer.toString(cant));
		 	response = restTemplate.postForEntity(getRootUrl() + "/contactos", obj, ContactoDtoResponse.class);
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.ERROR_VALIDACION, response.getBody().getEstado());
	        
	        
	 }
	

}
