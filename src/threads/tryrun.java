package threads;

import java.io.*;
import java.util.*;

public class tryrun {

	public static void main(String[] args) throws IOException
	{
		//Bring in the input file & prepare it for manipulation 
		FileInputStream fin = new FileInputStream("naruto.txt"); 
		Scanner scanner = new Scanner(fin); 
		
		//get the number of lines present in the input text file
		long linenumber = 0;
		while(scanner.hasNextLine())
		{
			linenumber++;
			System.out.println(linenumber);
		}
		
		
//		//Code for threads in the Main Method
//		Thread[] threads = new Thread[linenumber];
//		 for (int i = 0; i < linenumber; i++) {
//			 String string1 = scanner.nextLine();
//		     threads[i] = new Thread(new MyRunnable1(string1) );
//		     threads[i].start();
//		 }
//		 
		scanner.close();
		fin.close();
//	}

	}
}


//class MyRunnable1 implements Runnable {
//	
//	String string1;
//	public MyRunnable1(String string1) {
//		this.string1 = string1;
//	}
//	
//	@Override
//	public void run() {
//		
//		String[] stringArray = string1.split("\\s+");
//		
//		HashMap< String, Integer> hashmap = new HashMap<String, Integer>();
//		
//		for(int i=0;i<stringArray.length;i++)
//		{
//			String k = stringArray[i];
//			if(hashmap.containsKey(k))
//			{
//				hashmap.put(k, hashmap.get(k)+1);
//			}
//			else
//			{
//				hashmap.put(k, 1);
//			}
//				
//		}
//		
//		for(String s: hashmap.keySet())
//		{
//			String key = s;
//			String value = hashmap.get(s).toString();
//			System.out.println(key + " " + value);
//			
//		}
//		
//		System.out.println("-----------------------------------");
//		
//		
//	}
//
//	
//}
//}