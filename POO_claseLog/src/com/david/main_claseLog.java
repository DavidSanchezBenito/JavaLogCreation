package com.david;

import java.io.IOException;

public class main_claseLog {
//	https://www.youtube.com/watch?v=XKCEVICvW9w
//		Ejercicios Java - POO #24 - Clase Log
	public static void main(String[] args)  {
		
		try {
			//Log myLog = new Log("d:/log.txt");
			Log myLog = new Log("./log.txt");
			
			myLog.addLine("linea 1");
			myLog.addLine("linea 12");
			myLog.addLine("linea 13");
			myLog.addLine("linea 14");
			myLog.addLine("linea 15");
			myLog.addLine("FIN");
			
			String[] lines = myLog.getLines();
			for (int i = 0; i < lines.length; i++) {
				System.out.println(lines[i]);
				
			}
			myLog.resetLog();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}

}
