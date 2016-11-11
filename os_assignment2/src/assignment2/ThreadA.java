package assignment2;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ThreadA implements Runnable {
	
	//Local semaphores to catch value of semaphores
	Semaphore spA;
	Semaphore spB;
	Semaphore spC;
	public static String S1;
	
	//Custom Constructor
	public ThreadA(Semaphore spA, Semaphore spB, Semaphore spC)
	{
		this.spA = spA;
		this.spB = spB;
		this.spC = spC;
	}
	
	
	
	@Override
	public void run() {
		
		
		try {
			spA.acquire();
			System.out.println("Process 1 is running....");
			FileInputStream fip = new FileInputStream("readme.txt");
			Scanner sc = new Scanner(fip);
			String buffer = sc.useDelimiter("\\Z").next();
			sc.close();
			S1 = buffer;
		
			spA.release();//release semaphore spA
			
				
		} catch (InterruptedException | FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	
		
	
	
	
}
