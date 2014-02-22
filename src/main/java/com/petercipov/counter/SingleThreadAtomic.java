package com.petercipov.counter;

import java.util.concurrent.atomic.AtomicInteger;
import static com.petercipov.counter.SingleThreadPrimitive.ITERATIONS;

/**
 *
 * @author Peter Cipov
 */
public class SingleThreadAtomic {	
	private static final AtomicInteger counter = new AtomicInteger(0);
	
	public static void main( String[] args ) {
		long t = System.nanoTime();
        for(int i=0; i < ITERATIONS; i++) {
			counter.incrementAndGet();
		}
		System.out.println(System.nanoTime()-t);
	}
	
}
