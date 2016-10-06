package threads;

import java.io.*;
import java.util.*;


public class letsbegin {

	public static void main(String[] args) throws IOException
	{
		//Bring in the input file & prepare it for manipulation 
		FileInputStream fin = new FileInputStream("naruto.txt"); 
		Scanner scanner = new Scanner(fin);
		
		
		//Loop through each line and send it as a string to method
		while(scanner.hasNextLine())
		{
			
			String string1 = scanner.nextLine();
			stringManuplation(string1);
			
		}
		
		//Close all file streaming objects
		scanner.close();
		fin.close();
	}

//---------------------------------------------
	
	private static void stringManuplation(String string1) 
	{
		String[] stringArray = string1.split("\\s+");
		
		HashMap< String, Integer> hashmap = new HashMap();
		
		for(int i=0;i<stringArray.length;i++)
		{
			String k = stringArray[i];
			if(hashmap.containsKey(k))
			{
				hashmap.put(k, hashmap.get(k)+1);
			}
			else
			{
				hashmap.put(k, 1);
			}
				
		}
		
		for(String s: hashmap.keySet())
		{
			String key = s;
			String value = hashmap.get(s).toString();
			System.out.println(key + " " + value);
			
		}
		
		System.out.println("-----------------------------------");
		
	}



	

	

}
