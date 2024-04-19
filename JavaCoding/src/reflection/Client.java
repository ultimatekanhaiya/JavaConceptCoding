package reflection;

import java.lang.reflect.*;

public class Client {
	public static void main(String[] args)
			throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {

		//loading class using first way
		//getting class related info
		Class c = Employee.class;
		
		String className = c.getName();
		String superClassName = c.getSuperclass().getName();
		Class[] arr = c.getInterfaces();

		System.out.println("className: " + className);
		System.out.println("superClass: " + superClassName);
		for (Class carr : arr) {
			System.out.println(carr);
		}

		int i = c.getModifiers();
		System.out.println("Modifier: " + Modifier.toString(i));

		// loading class using second way
		//getting Fields related info
		Class c2 = Class.forName("reflection.Employee");
		
		Field[] flds = c2.getDeclaredFields();
		for (Field f : flds) {
			System.out.println("Name: " + f.getName() + " DataType: " + f.getType().getName());
			int j = f.getModifiers();
			System.out.println("Modifier: " + Modifier.toString(j));
			System.out.println("value: " + f.get(f));
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
		//loading class using third way
		//getting Methods related info
		Employee e = new Employee();
		
		Class c3 = e.getClass();
		Method[] mthd = c.getMethods();
		for(Method m: mthd) {
			System.out.println("Name: " + m.getName());
			System.out.println("Return Type: " + m.getReturnType().getName());
			int k = m.getModifiers();
			System.out.println("Modifier: " + Modifier.toString(k));
			Class[] cls1 = m.getParameterTypes();
			System.out.println("Parameter Types: ");
			for(Class cl1: cls1) {
				System.out.println(cl1.getName()+" ");
			}			
			Class[] cls2 = m.getExceptionTypes();
			for(Class cl2 : cls2) {
				System.out.println(cl2.getName());
			}
			System.out.println("--------------------------");
		}
	}

}
