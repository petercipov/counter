package com.petercipov.counter;

import static com.petercipov.counter.SingleThreadPrimitive.ITERATIONS;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Peter Cipov
 */
public class TwoThreadsLock {
	private static volatile int counter = 0; //has to be volatile otherway second thread could use invlaid value from procesor cache
	
	public static void main( String[] args ) throws Exception{
		final int THREADS_COUNT = 2;
		final int ITERATIONS_PER_THREAD = ITERATIONS / THREADS_COUNT;
		final Thread [] threads = new Thread[THREADS_COUNT];
		final ReentrantLock lock = new ReentrantLock();
		for (int i=0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {

				public void run() {
					for(int i=0; i < ITERATIONS_PER_THREAD; i++) {
						lock.lock();
						counter++;
						lock.unlock();
					}
				}
			});
		}
		
		
		long t = System.nanoTime();
        for (int i=0; i < THREADS_COUNT; i++) {
			threads[i].start();
		}
		for (int i=0; i < THREADS_COUNT; i++) {
			threads[i].join();
		}
		System.out.println(System.nanoTime()-t);
	}
}
