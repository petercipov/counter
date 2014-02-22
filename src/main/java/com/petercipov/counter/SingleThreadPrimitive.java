package com.petercipov.counter;

public class SingleThreadPrimitive {
	
	public static final int ITERATIONS = 600000000;
	
	private static int counter = 0;
	
    public static void main( String[] args ) {
		long t = System.nanoTime();
        for(int i=0; i < ITERATIONS; i++) {
			counter++;
		}
		System.out.println(System.nanoTime()-t);
    }
	
}
