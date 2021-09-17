package com.david;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Log {

	private BufferedWriter buffered;
	private String ruta;
	
	public Log(String ruta, boolean reset) throws IOException {
		
		this.ruta = ruta;
		this.open(!reset);  //metodo que creo abajo
	}
	/**
	 * @param ruta
	 * @throws IOException 
	 */
	public Log(String ruta) throws IOException {

		this.ruta = ruta;
		this.open(true); 
//		Writer fileWriter = new FileWriter("c:\\data\\output.txt", true);  //appends to file
//
//		Writer fileWriter = new FileWriter("c:\\data\\output.txt", false); //overwrites file
	}

	private void open(boolean append) throws IOException {
		//abre un BufferedWriter. Append indica si se debe añadir o empezar de nuevo
		this.buffered = new BufferedWriter(new FileWriter(this.ruta, append));
	}
	
	public void addLine(String linea) throws IOException {
		
		//ESCRIBE una linea al fichero: fecha y hora q se agregó + salto de línea
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		String formatoFecha = sdf.format(new Date());
		this.open(true);
		this.buffered.write("[" + formatoFecha + "]" + linea + "\n");
	
		this.close();
		
		

	}
	
	public String [] getLines() throws IOException {
		
		//devuelve un array con las lineas q contiene el fichero
		ArrayList<String> linesFile = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new FileReader(this.ruta));
		String line;
		while((line = bf.readLine()) !=null){
			linesFile.add(line);
		}
		bf.close(); 
		String [] lines = new String [linesFile.size()];
		
		for (int i = 0; i < linesFile.size(); i++) {
			 lines[i] = linesFile.get(i);
		}

		return lines;
			
			
		}
	
	public void resetLog() throws IOException {
		//resetea el log
	
	     this.open(false);
	        this.close();  //metodo creado 
	        System.out.println("fichero limpiado");
	}
	
	private void close() throws IOException {
		
		//cierra el bufferedwriter
		this.buffered.close();
	}
	
	}
	
	
	

