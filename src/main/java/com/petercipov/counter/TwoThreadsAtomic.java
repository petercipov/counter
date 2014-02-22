package com.petercipov.counter;

import static com.petercipov.counter.SingleThreadPrimitive.ITERATIONS;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Peter Cipov
 */
public class TwoThreadsAtomic {
	private static final AtomicInteger counter = new AtomicInteger(0);
	
	public static void main( String[] args ) throws Exception{
		final int THREADS_COUNT = 2;
		final int ITERATIONS_PER_THREAD = ITERATIONS / THREADS_COUNT;
		final Thread [] threads = new Thread[THREADS_COUNT];
		for (int i=0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {

				public void run() {
					for(int i=0; i < ITERATIONS_PER_THREAD; i++) {
						counter.incrementAndGet();
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
