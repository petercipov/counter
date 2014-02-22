package com.petercipov.counter;

import static com.petercipov.counter.SingleThreadPrimitive.ITERATIONS;

/**
 *
 * @author Peter Cipov
 */
public class SingleThreadVolatile {
	private static volatile int counter = 0;
	
	public static void main( String[] args ) {
		long t = System.nanoTime();
        for(int i=0; i < ITERATIONS; i++) {
			counter++;
		}
		System.out.println(System.nanoTime()-t);
	}
}
