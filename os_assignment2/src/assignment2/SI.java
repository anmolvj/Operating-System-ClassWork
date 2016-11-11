package assignment2;

import java.util.concurrent.Semaphore;

public class SI {

	public static void main(String[] args) {
		
			Semaphore s1 = new Semaphore(1);
			Semaphore s2 = new Semaphore(1);
			Semaphore s3 = new Semaphore(1);
			
			Thread P1 = new Thread(new P1(s1,s2,s3));
			Thread P2 = new Thread(new P2(s1,s2,s3));
			Thread P3 = new Thread(new P3(s1,s2,s3));
			
			P1.start();
			P2.start();
			P3.start();
	}

}
