package assignment2;

import java.util.concurrent.Semaphore;

public class P2 extends Thread{

	public static String S21;
	Semaphore s1;
	Semaphore s2;
	Semaphore s3;
	String buffer;
	public P2(Semaphore s1, Semaphore s2, Semaphore s3)
	{
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	
	
	public void run() {
		
		try {
			s2.acquire();
			Thread.sleep(2000);
			s1.acquire();
			S21 = new String(P1.S11);
			s1.release();
			s2.release();
			} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
