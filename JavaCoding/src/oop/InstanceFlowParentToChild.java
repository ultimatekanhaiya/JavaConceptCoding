package oop;

public class InstanceFlowParentToChild {
	
	public static void main(String[] args) {
		
		Child1 c = new Child1();
		System.out.println("Main Main");
	}
}

class Parent1 {

	int i = 10;

	{
		m1();
		System.out.println("Parent Instance Block");
	}

	Parent1() {
		System.out.println("Parent Constructor");
	}

	public static void main(String[] args) {

		Parent1 p = new Parent1();
		System.out.println("Parent Main");
	}

	public void m1() {
		System.out.println(j);
	}

	int j = 20;

}

class Child1 extends Parent1 {

	int x = 100;
	{
		m2();
		System.out.println("Child First Instance Block");
	}

	Child1() {
		System.out.println("Child Constructor");
	}

	public static void main(String[] args) {

		Child1 c = new Child1();
		System.out.println("Child Main");
	}

	public void m2() {
		System.out.println(y);
	}

	{
		System.out.println("Child Second Instance Block");
	}

	int y = 200;
}

/*
 * OUTPUT : 
 * 
0
Parent Instance Block
Parent Constructor
0
Child First Instance Block
Child Second Instance Block
Child Constructor
Main Main

 * 
 * */
