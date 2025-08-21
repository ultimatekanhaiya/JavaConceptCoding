package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<>();
        ls.addAll(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] arr = ls.stream().toArray(Integer[]::new);
    }


}

@FunctionalInterface
interface MyArrayGenerator<R> {
    R create(int size);
}

interface MyList<E> {

    int size();

    void add(E e);

    <A> A[] toArray(MyArrayGenerator<A[]> array);

}

class MyArrayList1<E> implements MyList<E> {

    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    MyArrayList1() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(E e) {

    }

    @Override
    public <A> A[] toArray(MyArrayGenerator<A[]> array) {
        return null;
    }
}


