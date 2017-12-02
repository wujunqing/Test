package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Testm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numThreads = 50;
		ExecutorService pool = Executors.newFixedThreadPool(numThreads);

		for (int i = 0; i < 100; i++) {
			
			Thread th	=new Thread(new Runnable() {

				@Override
				public void run() {
					Singleton singleton =Singleton.getInstance();
					System.out.println();
				}

			}, "Thread-" + i);
			System.out.println(th.getName());
			pool.submit(th);
		}
		
		pool.shutdown();

	}

}
