package oop;

public class FieldsAccessInheritance {

	public static void main(String[] args) {

		Child3 child = new Child3();
		child.dispaly();		
		Child3.main(new String[] {});

	}

}

class Parent3 {

	// static variable
	static int x = 50;

	// instance variable
	private int privateVar = 10;
	int defaultVar = 20;
	public int publicVar = 30;
	protected int protectedVar = 40;

	// getter for private variable
	public int getPrivateVar() {
		return privateVar;
	}

}

class Child3 extends Parent3 {

	static int x = 70;
	int defaultVar = 80;
	
	
	//instance area
	public void dispaly() {

		// always use Parent class name to access static variables
		System.out.println("static var: " + super.x);// Parent3.x (recommended)

		// System.out.println("Private Var: " + privateVar); // Error: privateVar is not accessible
		// Accessing private variable through getter method
        System.out.println("Private Var (via getter): " + getPrivateVar());
        
        System.out.println("Default Var: " + super.defaultVar); // Accessible if Child is in the same package as Parent
        
        System.out.println("Protected Var: " + protectedVar); // Accessible
        
        System.out.println("Public Var: " + publicVar); // Accessible        

	}
	
	//static area
	public static void main(String[] args) {
		
		Child3 child = new Child3(); 	
		
		// Accessing the instance variable of the subclass
		System.out.println(child.defaultVar);		
		// Accessing the instance variable of the superclass
		System.out.println(((Parent3)child).defaultVar);
		
		//// Accessing the static variables correctly
		System.out.println(Child3.x);
		System.out.println(Parent3.x);
		
		
//		System.out.println(super.x); //will throw error
		
		/*
		 * NOTE : 
		 * In Java, super is used within an instance method or constructor to access members (fields or methods) of the superclass.
		 * It cannot be used in a static method because static methods do not operate on instances of the class but rather at the class level.
		 *  
		 * */
		
	}

}
