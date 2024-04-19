package proxy;
import java.lang.reflect.Proxy;
import java.util.*;
public class Client {
	public static void main(String[] args) {
		Map fees =(Map) Proxy.newProxyInstance(
				HashMap.class.getClassLoader(), 
				new Class[] {Map.class},
				new ObjectHandler(new HashMap<>()));
		
		fees.put("java", 5000);
		fees.put("Python", 3000);
		fees.put("C", 4000);
		System.out.println(fees);
		
	}

}
