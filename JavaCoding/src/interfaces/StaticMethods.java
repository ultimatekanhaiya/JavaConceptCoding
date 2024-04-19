package interfaces;

public class StaticMethods implements Interf2 {

	public static void main(String[] args) {

		StaticMethods s = new StaticMethods();

		/*
		 * 
		 * Interface static methods are not available by default to implementation class. 
		 * Hence, Override concept not applicable to static methods.
		 * We have to call it by using Interface name only. 
		 * Therefore we can call static method of interface without implementing interface. 
		 * 
		 */
		// s.m1();

		// StaticMethods.m1();

		Interf2.m1();
	}

}

class Myclass {
	public static void main(String[] args) {
		Interf2.m1();
	}
}

interface Interf2 {

	static void m1() {
		System.out.println("Interface static method");
	}
}
