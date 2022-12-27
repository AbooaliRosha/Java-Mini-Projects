/*
*Date:April 21,2020
*Name:Rosha Abooali
*Teacher:Ms.A
*Description:Ask the user for a number then calulate the factorial.
*/
import java.util.Scanner;
public class Factorial{
    public static int factorialCalculaiotn(int number){
        int factorial=1;
        for(int i=1;i<=number;i++){
            factorial=factorial*i;
        }
        return factorial;
    }
	public static void main(String[] args) {
	    int factorial=1;
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.print("Enter a number:");
	    int number= scan.nextInt();
	    
	    factorial=factorialCalculaiotn(number);
	    System.out.print("factorial:"+factorial);
		
	}
}
