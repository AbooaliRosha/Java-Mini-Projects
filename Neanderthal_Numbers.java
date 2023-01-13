/*
Description: Finding all the possible neanderthal numbers of a given string using recursion
Sample test case (find in data.txt):
ookookook
oogamookoogumook
oogoogumookookmookmookookookmookook
mookookookugoogumoogummookmookugmookookmookmook
mookmookoogamoogumookookugoogugoogammookmookookookoogoogumugugookmookoogugug
ookugugugugoogookookugugugugmookmookugugugugugookookmookmookmookmookoogmookmookoogaooga
*/
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
class Neanderthal_Numbers
{
	public static void main(String[] args) throws IOException
	{
		//initializing variable that points to File
		FileReader dataFile = new FileReader("data.txt");

		//scanning with the file 
		Scanner fileParser = new Scanner(dataFile); 

		String line = " ";

		//getting the strings from the file while there are still strings remaining in the file
		while(fileParser.hasNext())  
		{
	        line = fileParser.next();
			int num = countNeanderthalWords(line);
	        System.out.println(num);
		}
		//closing file and Scanner
		fileParser.close();
	}
	public static int countNeanderthalWords(String line)
	{
		int index = 0;
		int counter = 0;
		String[] num = {"ook", "ookook", "oog", "ooga", "ug", "mook", "mookmook", "oogam", "oogum", "ugug"};

		if(line.length() == 0)  //base case which returns one when the end of the string is reached
		{
			return 1;
		}
		else
		{
			for(int i = 0; i < 10; i++) //looping over all the ten numbers
			{
				if(line.startsWith(num[i])) // checking if the string starts with one of the neanderthal words
				{
					index = num[i].length(); // if the string starts with one of the neanderthal words, the index is equal to the length of that word
					counter = counter + countNeanderthalWords(line.substring(index)); //adding the accumulator to the recursive case
				}
			}
			return counter; //returning the accumulator
		}
	}
}


		
