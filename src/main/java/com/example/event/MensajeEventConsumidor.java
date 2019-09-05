package com.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MensajeEventConsumidor {
	
	//private static final Logger LOG = LoggerFactory.getLogger(HelloWorldMessageConsumer.class);

	String cola;
	
	
	public MensajeEventConsumidor(@Value("${amqp.cola}") final String cola) {
		super();
		// TODO Auto-generated constructor stub
		this.cola=cola;
	}



	 //@JmsListener(destination = "example")
	 public void processMsg(MensajeEvent message) {
		 try {
	        System.out.println("============= Received: " + message.getMensaje());
		 }catch(Exception e)
		 {
			 //throw new AmqpRejectAndDontRequeueException(e);
		 }
	    }
	
	

}
