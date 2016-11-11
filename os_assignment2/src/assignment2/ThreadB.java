package assignment2;

import java.util.concurrent.Semaphore;

public class ThreadB implements Runnable {

	//Local semaphores to catch value of semaphores
	Semaphore spA;
	Semaphore spB;
	Semaphore spC;
	String buffer;
	public static String S2;
	
	//Custom Constructor number 1
		public ThreadB(Semaphore spA, Semaphore spB, Semaphore spC)
		{
			this.spA = spA;
			this.spB = spB;
			this.spC = spC;
		}
	
	
	@Override
	public void run() {
		
		try {
			spB.acquire();
			Thread.sleep(2000);
			spA.acquire();
			System.out.println("Process 2 is running....");
			S2 = new String(ThreadA.S1);//access static string S1 via class ThreadA's name
			
			
			spA.release();//release semaphore spA
			spB.release();//release semaphore spB
			
				
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
