package com.gulferorkurt.java8.lambda;

public class LambdaTest {

	public static void main(String[] args) {
		
	}
	
	static void startThreadWithLambda() {
		new Thread(() -> System.out.println("start thread with lambda")).start();
	}
	
	static void startThreadWithInner() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("start thread with inner class");
			}
			
		}).start();
	}

}
