package threads;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;


public class test33 {
	
public static void main(String[] args) throws IOException, Exception {
	
	//try block begins
	try{
		//Bring in the input file & prepare it for manipulation 
		FileInputStream fin = new FileInputStream("sample.txt"); 
		Scanner scanner = new Scanner(fin);
		
		//Initialize number of lines variable
		int numberOfLines = 0;
		
		
		//Get number of lines 
		//Put each line in a string variable
		//add each string to ArrayList
		while(scanner.hasNextLine())
		{	
			scanner.nextLine();
			numberOfLines+=1;
		}//while loop ends
		
		
		//Create a Variable to use line separation
		String newline = System.getProperty("line.separator");
		System.out.println( "PROGRAM BEGIN..." + newline + newline + newline );
		
		
		//An array of class MyThreadClass is created that extends the Thread class
		MyThreadClass[] thread = new MyThreadClass[numberOfLines];
		
		//Create new scanner object
		File f = new File("sample.txt");
		Scanner s1 = new Scanner(f);
        
		//Creating Individual threads
        for(int i=0;i<numberOfLines;i++)
        {
        	thread[i] = new MyThreadClass(s1.nextLine());
        	
        }
        
        //Starting individual threads
        for(int i=0;i<numberOfLines;i++)
        {
        	
        	thread[i].start();
        	TimeUnit.SECONDS.sleep(1);
        	
        }//while loop ends
        
        for(int i=0;i<numberOfLines;i++)
        {
        	
        	thread[i].join();
        	
        }//FOR loop ends
		
      
        //Main Hash Map Created 
		HashMap<String,Integer> mainMap = new HashMap<String, Integer>();
		
		//Put <Key,Value> data into MAIN Hash Map
		for(int i=0;i<numberOfLines;i++)
		{
			//Inner for loop begins
			for(String key : thread[i].hashmap.keySet() )
			{
				if(mainMap.containsKey(key))
				{
					mainMap.put(key, mainMap.get(key)+1);
				}
				else
				{
					mainMap.put(key, 1);
				}
			}//Inner FOR loop ends
			
		}//Main FOR loop ends
		
		System.out.println("FINAL FREQUENCY OF EACH WORD IN THE INPUT TEXT FILE:");
		for(String s: mainMap.keySet())
		{
			String key = s;
			String value = mainMap.get(s).toString();
			
			System.out.println( key + "-" + value );
		}

		
		s1.close();
		scanner.close();
		fin.close();
		}//try block ends
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}


//Thread Class Extended by User Defined Class
public static class MyThreadClass extends Thread {

	private String string;

	//Constructor
	public MyThreadClass(String string) {
		this.string = string;
	}
	
	//Created hash map for threads
	HashMap< String, Integer> hashmap = new HashMap<String, Integer>();

	
	//Over riding run method
	@Override
	public void run() {
				//RUN METHOD BEGINS
				
				//Filter The Incoming String
				//Split into words
				//Put words into a String Array
				String[] stringArray = string.replaceAll("\\s+", " ").split(" ");
				
				
				
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
						
				}//for loop ends
				

				
				System.out.println("INTERMEDIATE FREQUENCY CALCULATED BY THREAD" + "(" + Thread.currentThread().getId() + "):");
				for(String s: hashmap.keySet())
				{
					String key = s;
					String value = hashmap.get(s).toString();
					
					System.out.println( key+ "-" + value );
				}//for loop ends
				
				//Create a visual separation between results of each thread
				String newline = System.getProperty("line.separator");
				System.out.println(newline+newline);
				
	}//RUN METHOD ENDS
	
}//MyThreadClass definition ends

}//main class test33 ends. 














