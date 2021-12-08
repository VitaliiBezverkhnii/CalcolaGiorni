package main;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		int pulsante;
		
		System.out.println("\n[1] - Calcola giorni -\n[0] - Esci -");
		do {
			try {
				pulsante = Integer.parseInt(sc.nextLine());
				
			} catch(NumberFormatException e) {
				System.out.println(e.getMessage());
				pulsante = -1;
			}
			
			switch(pulsante) {
			
			case 1:
				System.out.println("===CALCOLA GIORNI===");
				
				int giorno = 0, mese = 0, anno = 0;
				Calendar dataDiNascita = Calendar.getInstance();
				
				try {
					System.out.println("- Giorno di nascita:");
					giorno = Integer.parseInt(sc.nextLine());
					
					System.out.println("- Mese di nascita:");
					mese = Integer.parseInt(sc.nextLine()) - 1;
					
					System.out.println("- Anno di nascita:");
					anno =Integer.parseInt(sc.nextLine());
					
					dataDiNascita.set(Calendar.DATE, giorno);
					dataDiNascita.set(Calendar.MONTH, mese);
					dataDiNascita.set(Calendar.YEAR, anno);
					
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					System.err.println("...Errore di input...");
				}
				
				long diferenza = Calendar.getInstance().getTimeInMillis() - dataDiNascita.getTimeInMillis();
				long giorni = diferenza / 1000 / 60 / 60 / 24;
				System.out.println("Giorni dalla nascita: " + giorni);
				break;
				
			case 0:
				System.out.println("===SEI USCITO===");
				break;
				
			default:
				System.err.println("...Errore di input...");
				
			}
		} while(pulsante != 0);
		
		sc.close();
	}
}
