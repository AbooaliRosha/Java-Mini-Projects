/*
Description: airport simulator using queue
*/
import java.util.Scanner;
public class Main_PlaneQueuing
{
	public static void main(String[] args)
	{
		// create an object of Queue class
		PlaneQueuing q = new PlaneQueuing();

		// initializing scanner
		Scanner input = new Scanner(System.in);

		// initializing variables
		char option = ' ';
		int flightNumber = 0;

		// while the user has not entered exit, continue the opperation
		do{
			System.out.println("[L]-landing	[R]-runway	[T]-take off	[P]-print	[exit]-exit");
		    System.out.println("Please select an option:");
		    option = input.next().charAt(0); //getting user's choice

			if(option == 'L')
			{
				System.out.println("Please enter flight number:");
		        flightNumber = input.nextInt(); //getting user's choice

				System.out.println("Flight " + flightNumber +" has landed, and joined its appropriate terminal.");
				System.out.println();
			}
			else if(option == 'R')
			{
				System.out.println("Please enter flight number:");
		        flightNumber = input.nextInt();

				q.enqueue(flightNumber); // inserts items to queue

				System.out.println("Flight " + flightNumber + " has joined the runway at the rear.");
				System.out.println();
			}
			else if(option == 'T')
			{
				System.out.println("Please enter flight number:");
		        flightNumber = input.nextInt();

				q.dequeue(flightNumber); // send the item to be deleted in queue
				System.out.println();
			}
			else if(option == 'P')
			{
				q.print();  // printing the queue list
			}

		}while(option == 'T' || option == 'R' || option == 'P' || option == 'L');

		System.out.println("Thank you for using the airport.");
	}
}