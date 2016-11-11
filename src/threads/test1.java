package threads;
import java.util.*;
import java.io.*;

public class test1 {

	public static void main(String[] args) throws IOException, Exception {
		
		System.out.println("Hello World");
		
		//Bring in the input file & prepare it for manipulation 
		FileInputStream fin = new FileInputStream("sample.txt"); 
		Scanner scanner = new Scanner(fin);
		
		//Initialize number of lines variable and create array-list to store each line
		int numberOfLines = 0;
		ArrayList<String> stringArrayList = new ArrayList<String>();
		
		//Get number of lines 
		//Put each line in a string variable
		//add each string to ArrayList
		while(scanner.hasNextLine())
		{	
			String nextLine = scanner.nextLine();
			stringArrayList.add(nextLine);
			numberOfLines+=1;
		}
		
		//Check if Array List is accurate
		for(int i=0; i<stringArrayList.size();i++)
		{
			System.out.println("Line: "+ i + "-->" + stringArrayList.get(i));
		}
		
		//Create a Variable to use line separation
		String newline = System.getProperty("line.separator");
		System.out.println( newline + "TOTAL NUMBER OF LINES: " + numberOfLines + newline + newline );
		
		//Hash map Test
		HashMap<String,Integer> mainMap = new HashMap<String, Integer>();
		
		
		//Implement Multiple Threads
		Thread[] threads = new Thread[numberOfLines];
		for(int i=0;i<numberOfLines;i++)
		{	
			
			threads[i] = new Thread(new MyRunnable(stringArrayList.get(i)));
			
			//mainMap = threads[i].start();
			threads[i].start();
			threads[i].join();
		}
		
		
		
		//Test to check whether thread ended before main re-executed
		System.out.print("CONTROL RETURNED TO MAIN");
		
		
		
		
		
		//close all data input streams
		scanner.close();
		fin.close();
	}

}








//Create a class that implements Runnable interface
class MyRunnable implements Runnable{
	
	//Hash Map for Thread
	HashMap< String, Integer> hashmap = new HashMap<String, Integer>();
	
	
	//Constructor to initialize string object thrown at this class by main
	private String threadString;
	public MyRunnable(String string) {
		this.threadString = string;
	}
	
	
	
	
	
	//Override the run method of Runnable interface
	@Override
	public void run() {
		System.out.println("RESULTS OF THREAD:  " + Thread.currentThread().getId());
		
		//Filter The Incoming String
		//Split into words
		//Put words into a String Array
		String[] stringArray = threadString.split("\\s+");
		
		
		//Put <Key,Value> data into Hash Map of Threads
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
		
		//Output thread's Intermediate <Key,Value> Pairs i.e. Word and its frequency
		for(String s: hashmap.keySet())
		{
			String key = s;
			String value = hashmap.get(s).toString();
			System.out.println( "'"+key+"'" + " was repeated " + value + " time(s).");
			
		}
		
		//Create a visual separation between results of each thread
		System.out.println("-----------------------------------");
		
		
		
	}
	

	
}