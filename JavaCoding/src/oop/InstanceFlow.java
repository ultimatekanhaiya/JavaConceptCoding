package oop;

public class InstanceFlow {

	int i = 10;

	{
		m1();
		System.out.println("First Instance Block");
	}

	InstanceFlow() {
		System.out.println("constructor");
	}

	public static void main(String[] args) {

		InstanceFlow inst = new InstanceFlow();
		System.out.println("Main Method");
	}

	public void m1() {
		System.out.println(j);
	}

	static {
		System.out.println("Static Block");
	}

	{
		System.out.println("Second Instance Block");
	}

	int j = 20;

}
