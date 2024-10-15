package oop;

public class InitializationExample {
    // Static variable
    static int staticVar = initializeStaticVar();

    // Static block
    static {
        System.out.println("Static block executed");
    }

    // Instance variable
    int instanceVar = initializeInstanceVar();

    // Instance block
    {
        System.out.println("Instance block executed");
    }

    // Constructor
    public InitializationExample() {
        System.out.println("Constructor executed");
    }

    // Static method for static variable initialization
    private static int initializeStaticVar() {
        System.out.println("Static variable initialized");
        return 10;
    }

    // Method for instance variable initialization
    private int initializeInstanceVar() {
        System.out.println("Instance variable initialized");
        return 20;
    }

    public static void main(String[] args) {
        System.out.println("Main method started");
        InitializationExample example = new InitializationExample();
        System.out.println("Instance variable value: " + example.instanceVar);
    }
}
