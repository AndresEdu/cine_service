package com.cine.salaService.business;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.cine.salaService.dto.Ack;
import com.cine.salaService.dto.Sala;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

@Component
public class SalaService {

	private static String salasCsv = ".\\src\\main\\resources\\csv\\salas.csv";

	public Ack createSala(Sala sala) {
		Ack ack = new Ack();

		if (buscarSala(sala.getIdSala()) == null) 
		{			
			try {
				FileWriter writer = new FileWriter(salasCsv, true);
				CSVWriter csvWriter = new CSVWriter(writer);

				String[] linea = { 
						Integer.toString(sala.getIdSala()), 
						Integer.toString(sala.getCantFilas()),
						Integer.toString(sala.getCantColumnas()),
						sala.getEstado() 
						};
				
				if(Integer.parseInt(linea[0]) < 0 || Integer.parseInt(linea[0]) > 3 )
				{
					ack.setDescription("Error: la sala debe ser 1,2 o 3");
					ack.setCode(-2);
				}
				else if(Integer.parseInt(linea[1]) < 0 || Integer.parseInt(linea[1]) > 10)
				{
					ack.setDescription("Error: las filas deben ser de 1 a 10");
					ack.setCode(-3);
				}
				else if(Integer.parseInt(linea[2]) < 0 || Integer.parseInt(linea[2]) > 10)
				{
					ack.setDescription("Error: las columnas deben ser de 1 a 10");
					ack.setCode(-3);
				}
				else 
				{
					csvWriter.writeNext(linea);
					ack.setDescription("Se ha guardado la sala");
					ack.setCode(0);
				}

				csvWriter.close();
			} catch (IOException e) {
				ack.setDescription("Error de almacenamiento");
				ack.setCode(-1);
				e.printStackTrace();
			}
		} 
		else 
		{
			ack.setDescription("Error: Ya existe una sala con ese id");
			ack.setCode(-1);
		}
		return ack;
	}
	
	public Ack readSala(int id)
	{
		Ack ack = new Ack();
		Sala s = buscarSala(id);
		
		if(s != null)
		{
			ack.setCode(0);
			
			ack.setDescription("id: " + s.getIdSala() + "\n" +					
					"Cantidad de filas: " + s.getCantFilas() + "\n" +
					"Cantidad de columnas: " + s.getCantColumnas() +"\n" +
					"Estado: " + s.getEstado() + "\n");
		} 
		else 
		{
			ack.setDescription("Error: No existe una sala con ese id");
			ack.setCode(-1);
		}

		
		return ack;
	}
	
	public Sala buscarSala(int id)
	{
		try {
			 
	        FileReader filereader = new FileReader(salasCsv);
	 
	        // create csvReader object passing
	        // file reader as a parameter
	        CSVReader csvReader = new CSVReader(filereader);
	        String[] sala;
	 
	        // we are going to read data line by line
	        while ((sala = csvReader.readNext()) != null) {
	            if(Integer.parseInt(sala[0]) == id)
	            {	            
	            	Sala s = new Sala();
	            	s.setIdSala(Integer.parseInt(sala[0]));
	            	s.setCantFilas(Integer.parseInt(sala[1]));
	            	s.setCantColumnas(Integer.parseInt(sala[2]));
	            	s.setEstado(sala[3]);
	            	return s;
	            }
	        }
	        
	        csvReader.close();
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return null;
	}

}
