package assignment2;

import java.util.concurrent.Semaphore;

public class ThreadC implements Runnable {

	//Local semaphores to catch value of semaphores
	Semaphore spA;
	Semaphore spB;
	Semaphore spC;
	public static String S3;
	
	//Custom Constructor
		public ThreadC(Semaphore spA, Semaphore spB, Semaphore spC)
		{
			this.spA = spA;
			this.spB = spB;
			this.spC = spC;
		}
	
	@Override
	public void run() {
		
		try {
			spC.acquire();
			Thread.sleep(2000);
			spB.acquire();
			Thread.sleep(2000);
			spA.acquire();
			System.out.println("Process 3 is running....");
			System.out.println("OUTPUT");

			S3 = new String(ThreadB.S2);//access static string S2 via class ThreadB's name
			System.out.println(S3);
			
			
			spA.release();
			spB.release();
			spC.release();
			
				
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
