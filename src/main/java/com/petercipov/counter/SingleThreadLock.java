package com.petercipov.counter;

import static com.petercipov.counter.SingleThreadPrimitive.ITERATIONS;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Peter Cipov
 */
public class SingleThreadLock {
	private static int counter = 0;
	
    public static void main( String[] args ) {
		ReentrantLock lock = new ReentrantLock();
		long t = System.nanoTime();
        for(int i=0; i < ITERATIONS; i++) {
			lock.lock();
			counter++;
			lock.unlock();
		}
		System.out.println(System.nanoTime()-t);
    }
}
