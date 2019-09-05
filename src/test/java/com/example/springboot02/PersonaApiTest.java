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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.Constantes;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBoot02Application.class) 
//@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PersonaApiTest {
	
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
	 public void testGetAllPersons() {
			ResponseEntity<PersonaDtoResponse> response = restTemplate.getForEntity(getRootUrl()+"/personas", PersonaDtoResponse.class);
	        //ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/personas",HttpMethod.GET, entity, String.class);
	        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	 }
	 
	 
	 @Test
	 public void testAddPersona() {
		 	PersonaDto obj = new PersonaDto();
		 	obj.setFirstName("nombre 1");
		 	obj.setTipoDocumentoId(1);
		 	obj.setLastName("apellido");
		 	obj.setEmail("xxx@gmail.com");
		 	obj.setPhoneNumber("111111");

		    ResponseEntity<PersonaDtoResponse> response = restTemplate.postForEntity(getRootUrl() + "/personas", obj, PersonaDtoResponse.class);
		    Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
	        Assert.assertEquals(Constantes.OK, response.getBody().getEstado());
	        Assert.assertEquals(obj.getFirstName(),response.getBody().getPersonaDto().get(0).getFirstName());
	        
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
