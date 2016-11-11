package assignment2;

import java.util.concurrent.Semaphore;

public class P3 extends Thread {
		
	Semaphore s1;
	Semaphore s2;
	Semaphore s3;
		public P3(Semaphore s1, Semaphore s2, Semaphore s3)
		{
			this.s1 = s1;
			this.s2 = s2;
			this.s3 = s3;
		}
	
	
	public void run() {
		
		try {
			s3.acquire();
			Thread.sleep(2000);
			s2.acquire();
			Thread.sleep(2000);
			s1.acquire();
			String S31;
			S31 = new String(P2.S21);
			System.out.println(S31);
			s1.release();
			s2.release();
			s3.release();
			
				
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
