package threads;

import java.io.*;
import java.util.*;

public class App {
	public static void main (String[] args) throws IOException
	{
		code();	
	}
	
	static void code() throws IOException
	{
		//Create input stream & scanner
				FileInputStream fin = new FileInputStream("readwords.txt"); 
				Scanner fileInput = new Scanner(fin);
				
				//Create the array list
				ArrayList<String> words = new ArrayList<String>();
				ArrayList<Integer> count = new ArrayList<Integer>();
				
				
		//Read through file and find the words
				while(fileInput.hasNext())
				{
					//get the next word
					String nextWord = fileInput.next();
					
					//Determine if the word is in array list already
					if(words.contains(nextWord))
					{
						int index = words.indexOf(nextWord);
						count.set(index, count.get(index) + 1) ;
					}
					else
					{
						words.add(nextWord);
						count.add(1);
					}
				}
				
				//Close 
				fileInput.close();
				fin.close();
				
				//Print out the results 
				for (int i= 0;i<words.size();i++)
				{
					System.out.println(words.get(i) + " occured " + count.get(i) + " Times." );
				}
				
	}

}
