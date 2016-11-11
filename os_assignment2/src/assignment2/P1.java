package assignment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class P1 extends Thread {
	
	public static String S11;
	Semaphore s1;
	Semaphore s2;
	Semaphore s3;
	public P1(Semaphore s1, Semaphore s2, Semaphore s3)
	{
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	

	public void run() {
		
		try {

			s1.acquire();
			FileInputStream fip = new FileInputStream("file.txt");
			Scanner sc = new Scanner(fip);
			String buffer = sc.useDelimiter("\\Z").next();
			sc.close();
			S11 = buffer;
			s1.release();} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
