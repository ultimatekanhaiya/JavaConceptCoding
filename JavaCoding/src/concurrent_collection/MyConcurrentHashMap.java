package concurrent_collection;

import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMap {
	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		map.put(101, "A");
		map.put(102, "B");
		map.putIfAbsent(103, "C");
		map.putIfAbsent(101, "D");
		map.remove(101, "D");
		map.replace(102, "B", "E");
//		map.reduce(0, null, null);
		map.replace(102, "B", "E");
		System.out.println(map);

	}

}
