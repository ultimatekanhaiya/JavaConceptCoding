package java_lang;

import java.util.Objects;

public final class ImmutablePerson {

    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ImmutablePerson modify(String name, int age) {
        if (this.equals(new ImmutablePerson(name, age)))
            return this;
        else
            return new ImmutablePerson(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || o.getClass() != getClass())
            return false;
        ImmutablePerson person = (ImmutablePerson) o;
        return age == person.getAge() && Objects.equals(name, person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}

/*
 * Immutability
 * An immutable object is an object whose state cannot be changed once it is
 * created. To achieve immutability, follow these guidelines:
 * 
 * 1. Declare the class as final so it can't be subclassed.
 * 2. Make all fields private and final so they can only be assigned once.
 * 3. Do not provide setters for the fields.
 * 4. Ensure that any mutable objects referenced by the class are not accessible
 * or modifiable outside the class. This can be done by making deep copies of
 * these objects.
 * 5. Provide a constructor to set all properties.
 * 
 * 
 */
