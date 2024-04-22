package method_reference;

import java.util.stream.Collectors;

public class MethodReferenceDemo {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        service.loadEmployeesFromDB().forEach(System.out::println);

        service.loadEmployeesFromDB().stream().map(new EmployeeMapper()::getEmployeeDto).collect(Collectors.toList());

        // get list of String of employee names
        service.loadEmployeesFromDB().stream().map(Employee::getName).collect(Collectors.toList());

        // printing employee names
        service.loadEmployeesFromDB().stream().map(Employee::getName).forEach(System.out::println);

        // Cannot make a static reference to the non-static method test(Employee) from
        // the type Employee
        // service.loadEmployeesFromDB().stream().map(Employee::test).forEach(System.out::println);

    }

}

/*
 * How can we call getName a non-static method using class name? like
 * Employee::getName
 * So basically in streams we can call instance methods using class name if they
 * doesn't have any parameters in it.
 * from above examples we can see that we are able to call Employee::getName
 * which is no parameter method but Employee::test throws error because it
 * contains parameter
 */
