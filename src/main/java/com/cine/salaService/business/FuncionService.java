package com.cine.salaService.business;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cine.salaService.dto.Ack;
import com.cine.salaService.dto.Funcion;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

@Component
public class FuncionService {

	private static String funcionesCsv = ".\\src\\main\\resources\\csv\\funciones.csv";

	public Ack createFuncion(Funcion f) {
		Ack ack = new Ack();

		if (buscarFuncion(f.getIdFuncion()) == null) {

			try {
				FileWriter writer = new FileWriter(funcionesCsv, true);
				CSVWriter csvWriter = new CSVWriter(writer);

				String[] linea = { 
						Integer.toString(f.getIdFuncion()), 
						f.getFecha(), 
						f.getHora(),
						Integer.toString(f.getIdPelicula()), 
						Integer.toString(f.getIdSala()),
						Float.toString(f.getCostoBoleto()), 
						f.getEstado() 
						};

				csvWriter.writeNext(linea);
				ack.setDescription("Se ha guardado la funcion");
				ack.setCode(0);

				csvWriter.close();
			} catch (IOException e) {
				ack.setDescription("Error de almacenamiento");
				ack.setCode(-1);
				e.printStackTrace();
			}
		} else {
			ack.setDescription("Error: Ya existe una funcion con ese id");
			ack.setCode(-1);
		}
		return ack;
	}

	public Ack readFuncion(int id) {
		Ack ack = new Ack();
		Funcion f = buscarFuncion(id);

		if (f != null) {
			ack.setCode(0);

			ack.setDescription(
					"ID: " + f.getIdFuncion() + "\n" + 
					"Fecha: " + f.getFecha() + "\n" + 
					"Hora: " + f.getHora() + "\n" + 
					"ID pelicula: " + f.getIdPelicula() + "\n" + 
					"# Sala asginada: " + f.getIdSala() + "\n" + 
					"Costo boleto: $" + f.getCostoBoleto() + "\n" + 
					"Estado: " + f.getEstado() + "\n");

		} else {
			ack.setDescription("Error: No existe una funcion con ese id");
			ack.setCode(-1);
		}

		return ack;
	}

	public Funcion buscarFuncion(int id) {
		try {

			FileReader filereader = new FileReader(funcionesCsv);

			CSVReader csvReader = new CSVReader(filereader);
			String[] funcion;

			while ((funcion = csvReader.readNext()) != null) {
				if (Integer.parseInt(funcion[0]) == id) {
					Funcion f = new Funcion();
					f.setIdFuncion(Integer.parseInt(funcion[0]));
					f.setFecha(funcion[1]);
					f.setHora(funcion[2]);
					f.setIdPelicula(Integer.parseInt(funcion[3]));
					f.setIdSala(Integer.parseInt(funcion[4]));
					f.setCostoBoleto(Float.parseFloat(funcion[5]));
					f.setEstado(funcion[6]);
					return f;
				}
			}

			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	public Ack cambiarEstado(int id, String nuevoEstado) {
		Ack ack = new Ack();
		FileReader fileReader = null;
		CSVReader csvReader = null;
		List<String[]> csvBody = null;
		int fila = 0;
		
		
		// Encontrar fila de la funcion a modificar
		try {
			fileReader = new FileReader(funcionesCsv);
			csvReader = new CSVReader(fileReader);
			String[] funcion;
			

			while ((funcion = csvReader.readNext()) != null) {
				if (Integer.parseInt(funcion[0]) == id) {
					break;
				}
				
				fila++;
			}

			csvReader.close();
			fileReader.close();
			
		} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Obtener contenido del csv
		try {
			fileReader = new FileReader(funcionesCsv);
			csvReader = new CSVReader(fileReader);
			
			csvBody = csvReader.readAll();
			// get CSV row column  and replace with by using row and column
			csvBody.get(fila)[6] = nuevoEstado;
			
			csvReader.close();
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// Reescribir csv con modificación
		try {
			FileWriter fileWriter = new FileWriter(funcionesCsv);
			CSVWriter csvWriter = new CSVWriter(fileWriter);
			csvWriter.writeAll(csvBody);
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ack.setCode(0);
		ack.setDescription("Se ha cambiado el estado de la funcion " + id);
		
		return ack;
	}
}
