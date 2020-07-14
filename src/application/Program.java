package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args)  {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = entrada.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(entrada.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(entrada.next());
			
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(entrada.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(entrada.next());
	
			reservation.updateDates(checkout, checkin);
			System.out.print("Reservation " + reservation);
			System.out.println();
			}
			catch (ParseException e ) {
				System.out.println("Invalid date format");
			}
			catch (DomainExceptions e) {
				System.out.println("Error of reservation: " + e.getMessage());
			}
			catch (RuntimeException e) {
				System.out.println("Unexpected error");
			}
		}
		

		
		
		
	

}
