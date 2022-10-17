package com.cine.salaService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cine.salaService.business.SalaService;
import com.cine.salaService.dto.Ack;
import com.cine.salaService.dto.Sala;

@Endpoint
public class SalasEndpoint {
	private static final String NAMESPACE_URI = "http://com.cine";
	
	@Autowired SalaService salaService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "Sala")
	@ResponsePayload
	public Ack salaRegistration(@RequestPayload Sala request) {
		Ack response = salaService.createSala(request);
		
		return response;
		
	}

}
