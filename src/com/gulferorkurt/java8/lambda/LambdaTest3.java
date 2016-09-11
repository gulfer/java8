package com.gulferorkurt.java8.lambda;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class LambdaTest3 {

	public static void main(String[] args) {
		LambdaTest3 test = new LambdaTest3();
		int ceiling = 10000;
		
		long start = System.currentTimeMillis();
		System.out.println("Count primes from 0 up to " + ceiling + " with Anonymous Class ===");
		System.out.println("count : " + test.countPrimesWithAC(ceiling));
		System.out.println("use : " + (System.currentTimeMillis() - start));
		
		System.out.println("======");
		
		start = System.currentTimeMillis();
		System.out.println("Count primes from 0 up to " + ceiling + " with Lambda ===");
		System.out.println("count : " + test.countPrimesWithLambda(ceiling));
		System.out.println("use : " + (System.currentTimeMillis() - start));
		
		System.out.println("======");
		start = System.currentTimeMillis();
		System.out.println("Count primes from 0 up to " + ceiling + " with final Anonymous Class ===");
		System.out.println("count : " + test.countPrimesWithFinalAC(ceiling));
		System.out.println("use : " + (System.currentTimeMillis() - start));
		
		System.out.println("======");
		start = System.currentTimeMillis();
		System.out.println("Count primes from 0 up to " + ceiling + " with final Lambda ===");
		System.out.println("count : " + test.countPrimesWithFinalLambda(ceiling, test.predicate1));
		System.out.println("use : " + (System.currentTimeMillis() - start));
		
		
//		while(true) {
//			Thread.yield();
//		}
	}
	
	int countPrimesWithAC(int ceiling) {
		return new PrimeCounter() {

			@Override
			int countPrimes(int ceiling) {
				int count = 0;
				for (int i=0;i<ceiling;i++) {
					if (isPrime(i)) {
//						System.out.println(i);
						count++;
					}
				}
				return count;
			}
			
		}.countPrimes(ceiling);
	}
	
	int countPrimesWithFinalAC(int ceiling) {
		return primeCounter.countPrimes(ceiling);
	}
	
	final PrimeCounter primeCounter = new PrimeCounter() {

		@Override
		int countPrimes(int ceiling) {
			int count = 0;
			for (int i=0;i<ceiling;i++) {
				if (isPrime(i)) {
					count++;
				}
			}
			return count;
		}
		
	};
	
	final IntPredicate predicate1 = (i) -> isPrime(i);
	
	long countPrimesWithLambda(int ceiling) {
		return IntStream.range(0, ceiling).parallel().filter(i -> isPrime(i)).count();
	}
	
	boolean isPrime(int i) {
		for (int j=2;j<i;j++) {
//		for (int j=2;j<=Math.sqrt(i);j++) {
			if (i%j == 0) {
				return false;
			}
		}
		return true;
	}
	
	boolean isPrime1(int i) {
		return IntStream.range(2, i).parallel().allMatch(j -> (i%j != 0));
	}
	
	long countPrimesWithFinalLambda(int ceiling, IntPredicate predicate) {
		return IntStream.range(0, ceiling).filter(predicate).count();
	}
	
	abstract class PrimeCounter {
		
		abstract int countPrimes(int ceiling);
		
	}

}
