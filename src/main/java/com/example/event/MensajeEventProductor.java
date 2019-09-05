package com.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MensajeEventProductor {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	
	private MensajeEvent mensajeEvent;
	String cola;
	
	
	public MensajeEventProductor(@Value("${amqp.cola}") final String cola) {
		super();
		// TODO Auto-generated constructor stub
		this.cola=cola;
	}



	public void send(MensajeEvent mensajeEvent) {
		this.jmsTemplate.convertAndSend(this.cola,mensajeEvent);
	}
	
	

}
