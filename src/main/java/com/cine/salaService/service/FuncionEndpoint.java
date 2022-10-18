package com.cine.salaService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cine.salaService.business.FuncionService;
import com.cine.salaService.dto.Ack;
import com.cine.salaService.dto.EstadoFuncion;
import com.cine.salaService.dto.FuncionCreator;
import com.cine.salaService.dto.FuncionReader;

@Endpoint
public class FuncionEndpoint {
	private static final String NAMESPACE_URI = "http://com.cine";
	
	@Autowired FuncionService funcionService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "funcionCreator")
	@ResponsePayload
	public Ack funcionRegistration(@RequestPayload FuncionCreator request) {
		Ack response = funcionService.createFuncion(request.getFuncion());
		
		return response;
		
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "funcionReader")
	@ResponsePayload
	public Ack funcionRead(@RequestPayload FuncionReader request) {
		Ack response = funcionService.readFuncion(request.getIdFuncion());
		
		return response;
		
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "estadoFuncion")
	@ResponsePayload
	public Ack funcionChangeState(@RequestPayload EstadoFuncion request) {
		Ack response = funcionService.cambiarEstado(
				request.getIdFuncion(), 
				request.getEstado());
		
		return response;
		
	}

}
