package com.cine.salaService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cine.salaService.business.FuncionService;
import com.cine.salaService.business.SalaService;
import com.cine.salaService.dto.Ack;
import com.cine.salaService.dto.Funcion;
import com.cine.salaService.dto.FuncionCreator;
import com.cine.salaService.dto.FuncionReader;
import com.cine.salaService.dto.SalaCreator;
import com.cine.salaService.dto.SalaReader;

@Endpoint
public class SalasEndpoint {
	private static final String NAMESPACE_URI = "http://com.cine";
	
	@Autowired SalaService salaService;
	@Autowired FuncionService funcionService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "salaCreator")
	@ResponsePayload
	public Ack salaRegistration(@RequestPayload SalaCreator request) {
		Ack response = salaService.createSala(request.getSala());
		
		return response;
		
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "salaReader")
	@ResponsePayload
	public Ack salaRead(@RequestPayload SalaReader request) {
		Ack response = salaService.readSala(request.getIdSala());
		
		return response;
		
	}

}