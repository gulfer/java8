package com.gulferorkurt.java8.lambda;

public class LambdaTest2 {

	private String s = "outter";
	
	public static void main(String[] args) {
		
		LambdaTest2 test = new LambdaTest2();
		test.sayHelloInInner(test);
		test.sayHelloInLambda(test);
				
	}
	
	void sayHelloInInner(LambdaTest2 test){
		test.sayHello(new Hello2() {
			
			private String s = "inner";

			@Override
			public void print() {
				System.out.println(this.s);
			}
			
		});
	}
	
	void sayHelloInLambda(LambdaTest2 test) {
		test.sayHello(() -> System.out.println(this.s));
	}
	
	void sayHello(Hello2 hello) {
		hello.print();
	}

}

interface Hello2 {
	
	void print();
	
}
