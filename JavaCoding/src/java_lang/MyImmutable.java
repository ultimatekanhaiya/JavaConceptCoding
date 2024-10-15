package java_lang;

import java.util.Objects;

public class MyImmutable {

    public static void main(String[] args) {
        ImmutablePerson person1 = new ImmutablePerson("Raj", 29);
        ImmutablePerson person2 = person1.modify("Ravi", 25);
        ImmutablePerson person3 = person1.modify("Raj", 29);

        System.out.println(person1 == person3);
        System.out.println(person1 == person2);
    }

}
