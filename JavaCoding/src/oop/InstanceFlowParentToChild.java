package oop;

public class InstanceFlowParentToChild {
	
	public static void main(String[] args) {
		
		Child1 c = new Child1();
		
		System.out.println("Main Main");
	}
}

class Parent1 {

	int i = 10;
	int k  = 0;
	int l = 0;
	int m = 9;	

	public Parent1(int i, int k, int l, int m, int j) {
		this.i = i;
		this.k = k;
		this.l = l;
		this.m = m;
		this.j = j;
		System.out.println("paremeterized constructor");
	}

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
		super();
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
