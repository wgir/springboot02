package com.example.springboot02;

//import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;

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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.constantes.Constantes;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBoot02Application.class) 
//@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Order(value = 1)
public class PersonaApiTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;

	 @LocalServerPort
	 private int port;

	 private String getRootUrl() {
	    return "http://localhost:" + port + "/api/persona";
	 }

	 HttpHeaders headers = new HttpHeaders();
     HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	  
	 @Test
	 public void contextLoads() {
	 }
	
	 @Test
	 public void testGetAllPersons() {
			ResponseEntity<PersonaDtoResponse> response = restTemplate.getForEntity(getRootUrl()+"/personas", PersonaDtoResponse.class);
	        //ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/personas",HttpMethod.GET, entity, String.class);
	        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	 }
	 
	 
	 @Test
	 public void testAddPersona() {
		 	
		 	ResponseEntity<PersonaDtoResponse> response = restTemplate.getForEntity(getRootUrl()+"/personas", PersonaDtoResponse.class);
		 	int cant=response.getBody().getPersonaDto().size();
		 	PersonaDto obj = new PersonaDto();
		 	obj.setId((long) 0);
		 	obj.setNombres("nombre "+(cant+1));
		 	obj.setDocumento(0);
		 	obj.setApellidos("apellido "+(cant+1));
		 	obj.setEmail("xxx"+(cant+1)+"@gmail.com");
		 	

		    response = restTemplate.postForEntity(getRootUrl() + "/personas", obj, PersonaDtoResponse.class);
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	        Assert.assertEquals(obj.getNombres(),response.getBody().getPersonaDto().get(0).getNombres());
	        
	 }
	/*
	 @Test
		public void getDataTest() {
		 
		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/echo/hola",
		            HttpMethod.GET, entity, String.class);
		 Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
		 System.out.println("testing echo"+response.getBody());
		        
			//get(getRootUrl()+"/echo/hola").then().assertThat().body("data", equalTo("hola"));
		}
	 
	 
	 	@Test
		public void firstEchoTest() {
			get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
		}*/

}
