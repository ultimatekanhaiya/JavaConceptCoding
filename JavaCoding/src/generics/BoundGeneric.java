package generics;

public class BoundGeneric {

	public static void main(String[] args) {

		Test<Integer> t = new Test<>();

		Test2<MyClass> t2 = new Test2();

		MyArrayList<Integer> list = new MyArrayList<>();
		
		MyHashMap<String, Integer> map = new MyHashMap<>();

	}

}

class Test<T extends Number> {
	
	T a, b;

	void add(T a, T b) {
		
	}

}

class MyArrayList<T> {

	T a;

	void add(T obj) {

	}

	T get(int index) {
		return this.a;
	}
}

class Test1<T extends Runnable> {

}

class Test2<T extends Number & Runnable & Comparable<Integer>> {

}

class MyHashMap<T, X> {

}

class MyClass extends Number implements Runnable, Comparable<Integer> {

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}