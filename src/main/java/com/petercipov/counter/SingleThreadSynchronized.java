package com.petercipov.counter;

import static com.petercipov.counter.SingleThreadPrimitive.ITERATIONS;

/**
 *
 * @author Peter Cipov
 */
public class SingleThreadSynchronized {
	private static int counter = 0;
	
    public static void main( String[] args ) {
		Object o = new Object();
		long t = System.nanoTime();
        for(int i=0; i < ITERATIONS; i++) {
			synchronized(o) {
				counter++;
			}
		}
		System.out.println(System.nanoTime()-t);
    }
}
