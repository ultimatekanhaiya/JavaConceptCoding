package generics;

import java.util.ArrayList;
import java.util.List;

public class PECS {
    public static void main(String[] args) {

    }
}

interface Shape {
    double getArea();
}

class Circle implements Shape {

    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}


class Square implements Shape {

    private final double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

class GeometryUtils {
    public static void main(String[] args) {
        List<Circle> circles = List.of(new Circle(2), new Circle(3));
        List<Square> squares = List.of(new Square(2), new Square(3));
        List<Shape> mixShapes = List.of(new Circle(2), new Square(3));

    }

    public double calcTotalArea(List<? extends Shape> list) {

        double totalArea = 0;
        for (Shape shape : list) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}

class CollectionUtils {

    public static void addIntegers(List<? super Integer> destination, int count) {

        for (int i = 1; i <= count; i++) {
            destination.add(i);
        }
//        Integer a = destination.get(0); //get compile error because runtime time object can be any superType of Integer
//        Object obj = destination.get(0); // compile fine
    }

    public static <T> void copy(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

}