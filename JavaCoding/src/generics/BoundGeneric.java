package generics;

import java.util.ArrayList;

public class BoundGeneric {

    public static void main(String[] args) {

        Test<Integer> t = new Test<>();
        t.add(1, 3);

        BoundedGeneric2<MyClass> t2 = new BoundedGeneric2<>();

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(12);

        MyHashMap<String, Integer> map = new MyHashMap<>();

        GenericInterface<Runnable> gi = new GenericInterface<>();
        gi.al.add(new Thread() {

        });

        GenericInterface<GenericInterf1> anInterface = new GenericInterface<>();
        anInterface.al.add(new ImplGenericInterf1());
    }

}

/**
 * Here’s the fundamental reason why:
 * <p>
 * Operators vs. Methods: In Java, the arithmetic operator + is defined for primitive types (int, double, long, etc.) and, via a special case, for String concatenation.
 * It is not defined for objects, including the Number class. When you use it on wrapper types like Integer or Double, a process called auto-unboxing happens,
 * which converts the object back to its primitive form (int or double) before the addition.
 * <p>
 * Type Erasure: This is the most critical concept here. During compilation, the generic type information is "erased" and replaced by its bound.
 * In your case, the compiler replaces every T with Number. So, after erasure, your method effectively looks like this to the JVM:
 * <p>
 * <p>
 * // What the compiler "sees" after erasure
 * <p>
 * Number add(Number a, Number b) {
 * // The compiler must validate this line based on the 'Number' class
 * return a + b; // ERROR: The 'Number' class does not have a '+' operator.
 * }
 */
class Test<T extends Number> {

    T add(T a, T b) {
        //Compile error here
//        return a + b;
        return null;
    }

    //correct way to create above method
    Double addCorrect(T a, T b) {
        if (a == null || b == null) return null;
        return a.doubleValue() + b.doubleValue();
    }

}


//My custom Arraylist class
class MyArrayList<T> {

    private final ArrayList<T> al = new ArrayList<>();

    void add(T obj) {
        al.add(obj);
    }

    T get(int index) {
        return al.get(index);
    }

    ArrayList<T> getAll() {
        return al;
    }
}

//class with single bounded type
class BoundedGeneric1<T extends Runnable> {

}

//class with multiple bounded type
class BoundedGeneric2<T extends Number & Runnable & Comparable<Integer>> {

}

//this sample class can be used where type parameter is of type: BoundedGeneric2
class MyClass extends Number implements Runnable, Comparable<Integer> {

    @Override
    public int compareTo(Integer o) {
        return 0;
    }

    @Override
    public void run() {
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

}

//class with multiple parameter types
class MyHashMap<T, X> {

}

class GenericInterface<T extends Runnable> {

    ArrayList<T> al = new ArrayList<>();

    void add(T t) {
        al.add(t);
    }

    T get(int index) {
        return al.get(index);
    }

}

interface GenericInterf1 extends Runnable {

}

class ImplGenericInterf1 implements GenericInterf1 {
    @Override
    public void run() {

    }
}