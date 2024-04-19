package concurrent_collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;

public class WithConcurrentCollection {

	public static void main(String[] args) throws InterruptedException {

		MyThread1 t = new MyThread1();
		t.start();

		MyThread1.map.put(101, "A");
		MyThread1.map.put(102, "B");
		MyThread1.map.put(103, "C");

		Set<Integer> s = MyThread1.map.keySet();

		Iterator<Integer> itr = s.iterator();

		while (itr.hasNext()) {
			Integer i = itr.next();
			System.out.println(
					"Main Thread Iterating map and Current Object entry is : " + i + " " + MyThread1.map.get(i));
			Thread.sleep(3000);
		}
		System.out.println(MyThread1.map);
	}

}

class MyThread1 extends Thread {

	static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Child Thread updating map");
		map.put(104, "D");
	}
}
