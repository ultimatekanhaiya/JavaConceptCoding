package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ObjectHandler implements InvocationHandler{
	
	private Object object;	

	public ObjectHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if(method.getName().contains("put")) {
			if(args[0].equals("java")) {
				System.out.println("Invalid key: java");
				return null;
			}
		}
		
		//logic before method call
		System.out.println("before method call");
		
		Object invoke = method.invoke(object, args);
		
		System.out.println("after method call");
		//logic after method call
		
		return invoke;
	}

}
