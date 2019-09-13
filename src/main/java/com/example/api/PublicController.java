package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.MensajeEvent;
import com.example.event.MensajeEventProductor;

@RestController
@RequestMapping("/api/public")
public class PublicController {
	
	@Autowired
	MensajeEventProductor mensajeEventProductor;
		
		
	
	
	@GetMapping({"/getMessage"})
    public String getMessage() {
        return "Hello from public API controller";
    }
	
	@GetMapping({"/sendMessage/{mensaje}"})
    public String sendMessage(@PathVariable String mensaje) {
		 	MensajeEvent mensajeEvent=new MensajeEvent(1,mensaje);
		 	//mensajeEventProductor=new MensajeEventProductor(mensajeEvent);
		 	try {
		 	mensajeEventProductor.send(mensajeEvent);
		 	}catch(Exception e) {
		 		System.out.println("Error al enviar al broker: "+e.getMessage());
		 	}
	        return "ok";
    }
}