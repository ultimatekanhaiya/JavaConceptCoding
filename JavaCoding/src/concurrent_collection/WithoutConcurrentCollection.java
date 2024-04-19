package concurrent_collection;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class WithoutConcurrentCollection {

	public static void main(String[] args) throws InterruptedException {

		MyThread t = new MyThread();
		t.start();

		MyThread.list.add(1);
		MyThread.list.add(2);
		MyThread.list.add(3);

		Iterator<Integer> itr = MyThread.list.iterator();

		while (itr.hasNext()) {
			Integer i = itr.next();
			System.out.println("Main Thread Iterating List and Current Object is : " + i);
			Thread.sleep(3000);
		}
		System.out.println(MyThread.list);
	}

}

class MyThread extends Thread {

	static List<Integer> list = new ArrayList<>();

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Child Thread updating list");
		list.add(4);
	}
}
