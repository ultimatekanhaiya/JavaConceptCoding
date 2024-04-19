package static_flow;

public class StaticFlow {
	
	static {
		m1();
	}
	
	public static void m1() {
		System.out.println(x);
	}
	
	static int x = 10;

}
