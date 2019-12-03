package dev.oop.game.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Util 
{
public static String loadFileToString(String path)
{
	
	/*This method will be used to store
	 * the contents of a file
	 * to a string. Mainly for loading data
	 * into game.
	 */
	StringBuilder builder = new StringBuilder();
	
	try
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String currentLine;
		
		while((currentLine = br.readLine()) != null)
		{
			builder.append(currentLine + "\n");
		}
		br.close();
	}
	
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	return builder.toString();
}




public static int parseInt(String number)
{
	/*This method is going to 
	 * convert a string into
	 * an integer
	 */
	
	try
	{
		return Integer.parseInt(number);
	}
	
	catch(NumberFormatException e)
	{
		e.printStackTrace();
		return 0;
	}
}


}
