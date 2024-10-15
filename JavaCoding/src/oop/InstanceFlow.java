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
		InstanceFlow inst2 = new InstanceFlow();
		System.out.println(inst.j);
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
// static flow will always occur before instance flow.
// identification of instance members from top to bottom
// execution of instance variable assignment and instance block.
// calling constructor
