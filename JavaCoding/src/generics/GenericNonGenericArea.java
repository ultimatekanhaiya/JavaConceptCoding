package generics;

import java.util.ArrayList;

public class GenericNonGenericArea {
    public static void main(String[] args) {

        ArrayList<String> genericList = new ArrayList<String>();
        genericList.add("foo");
        genericList.add("boo");
        genericList.add("koo");
        genericList.add("yoo");

        nonGenericArea(genericList);

        ArrayList nonGenericList = new ArrayList<String>();
        nonGenericList.add(8);
        nonGenericList.add(false);
        nonGenericList.add("bye");
        nonGenericList.add("hi");

        genericArea(nonGenericList);
    }

    public static void nonGenericArea(ArrayList list) {
        list.add(1);
        list.add(true);
        list.add("hello");

        System.out.println(list);
    }

    public static void genericArea(ArrayList<Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
    }

    // why below overloading is not possible ?

    // public static void m1(ArrayList<Integer> list) {
    // }

    // public static void m1(ArrayList<String> list) {
    // }

    // CE : Erasure of method m1(ArrayList<String>) is the same as another method

    // Explanation :
    // Erasure : - It is nothing but method signature after removing generic syntax
    // from it.
    // At compile time :
    // i. Compile code normally by considering generic syntax.
    // ii. Remove generic syntax
    // iii. Compile once again resultant code

}

/*
 * If we send generic object to non-generic area then it starts behaving like
 * non-generic object.
 * Similarly, if we send non-generic object to generic area then it starts
 * behave like generic object.
 * i.e. the location in which object present based on that behavior will be
 * defined.
 */
