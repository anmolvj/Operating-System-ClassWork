package assignment2;
import java.util.concurrent.Semaphore;

public class Assign2 {

	public static void main(String[] args) {
		Semaphore spA = new Semaphore(1);
		Semaphore spB = new Semaphore(1);
		Semaphore spC = new Semaphore(1);
		
		Thread thread1 = new Thread(new ThreadA(spA,spB,spC));
		Thread thread2 = new Thread(new ThreadB(spA,spB,spC));
		Thread thread3 = new Thread(new ThreadC(spA,spB,spC));
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

