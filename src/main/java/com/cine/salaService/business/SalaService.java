package com.cine.salaService.business;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.cine.salaService.dto.Ack;
import com.cine.salaService.dto.Sala;
import com.opencsv.CSVWriter;


@Component
public class SalaService {
	
	public Ack createSala(Sala sala) {
		Ack ack = new Ack();
		
		try {			
			FileWriter writer = new FileWriter(".\\src\\main\\resources\\csv\\salas.csv", true);
			CSVWriter csvWriter = new CSVWriter(writer);
			
			String[] linea = {
					Integer.toString(sala.getIdSala()),
					Integer.toString(sala.getCantFilas()),
					Integer.toString(sala.getCantColumnas()),
					sala.getEstado()
			};
			
			csvWriter.writeNext(linea);
			ack.setDescription("Se ha guardado la sala");
			ack.setCode(0);
			
			csvWriter.close();
		} catch (IOException e) {
			ack.setDescription("Error de almacenamiento");
			ack.setCode(-1);
			e.printStackTrace();
		}						
		
		return ack;
	}
}
