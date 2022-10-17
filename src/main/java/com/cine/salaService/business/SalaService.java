package com.cine.salaService.business;

import org.springframework.stereotype.Component;

import com.cine.salaService.dto.Ack;
import com.cine.salaService.dto.Sala;


@Component
public class SalaService {
	public Ack createSala(Sala sala) {
		Ack ack = new Ack();
		
		ack.setDescription("idSala" + sala.getIdSala() + "\n" +
		"fila " + sala.getFila() + 
		"columna " + sala.getColumna() +
		"estado " + sala.getEstado());
		
		ack.setCode(0);
		
		return ack;
	}
}
