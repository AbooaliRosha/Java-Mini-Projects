import java.util.Scanner;

public class Pro1_abooalir {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in); //Initializing scanner
		
		double input; //Initializing variables
		
		System.out.println("   JAVA CONVERSION PROGRAM");
		System.out.println("0 - Quit");
		System.out.println("1 - Convert feet and inches to centimeters");
		System.out.println("2 - Convert centimeters to feet and inches");
		System.out.println();
		System.out.print("Enter choice: ");
		input = userInput.nextDouble(); //getting the user input
		
		// the program will keep asking for user prompt until 0 is entered 
		while(input != 0)
		{
		    if(input == 1) // convert feet and inches to centimeters if entered 1
		    {
		        double feet;
		        double inch;
		        
		        System.out.println(); // adding space for formatting
		        System.out.print("Enter feet and inches: ");
		        feet = userInput.nextDouble();
		        inch = userInput.nextDouble();
		        
		        if(feet < 0 || inch< 0) //display error message and show the menu again if a negative number is entered
		        {
		            System.out.println("ERROR: Negative numbers not allowed!");
		            
		        }
		        else
		        {
		            double feetToInch = feet * 12.0; // convert feet to inch
		            double inchToCm = (feetToInch+inch) * 2.54; //add the converted feet to inch to the prompted inch and convert it to cm
		        
		            System.out.println(feet +" feet " + inch + " inches equals " + inchToCm + " centimeters.");
		        }   
		    }
		    else if(input==2) //convert centimeters to feet and inches when 2 is entered
		    {
		        double cm;
		        System.out.println();
		        System.out.print("Enter centimeters: ");
		        cm = userInput.nextDouble();
		        
		        if(cm < 0)
		        {
		            System.out.println("ERROR: Negative numbers not allowed!");
		        }
		        else
		        {
		        	//calculating inch
		             double cmToInch = cm / 2.54;
		             double inch = cmToInch % 12.0;
		             
		             // calculating feet
		             double feet = cm / 30.48;
		             
		             // use math.floor() to round feet downward with one decimal place
		             System.out.println(cm +" centimeters" +" equals " + Math.floor(feet) + " feet " + inch + " inches.");
		        }
		    }
		    else
		    {
		        System.out.println();
		        System.out.println("ERROR: Invalid menu choice!");
		    }
		    System.out.println();
		    System.out.println("   JAVA CONVERSION PROGRAM");
		    System.out.println("0 - Quit");
		    System.out.println("1 - Convert feet and inches to centimeters");
		    System.out.println("2 - Convert centimeters to feet and inches");
		    System.out.println();
		    System.out.print("Enter choice: ");
		    input = userInput.nextDouble();
		}
		System.out.println();
		System.out.println("Goodbye!");
	}

}
