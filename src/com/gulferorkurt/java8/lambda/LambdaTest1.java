package com.gulferorkurt.java8.lambda;

public class LambdaTest1 {

	public static void main(String[] args) {
		
		int i = 1000;
//		i+=1;
		sayHello(() -> "Hello " + i);
		
	}
	
	static void sayHello(Hello h) {
		System.out.println(h.hello());
	}

}

interface Hello {
	
	String hello();
	
}
