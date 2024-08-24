import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    int age;
    double salary;
    boolean isHighPerformer;

    Employee(String name, int age, double salary, boolean isHighPerformer) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isHighPerformer = isHighPerformer;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isHighPerformer() {
        return isHighPerformer;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Salary: $" + salary + ", High Performer: " + isHighPerformer + ")";
    }
}

public class employeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Pancho", 28, 80000, true),
            new Employee("Rick", 35, 120000, true),
            new Employee("Morty", 40, 100000, false),
            new Employee("Enzo", 29, 95000, true),
            new Employee("Ramiro", 42, 70000, false),
            new Employee("Facundo", 31, 115000, true),
            new Employee("Mike", 38, 85000, false)
        );

        List<Employee> topPerformers = employees.stream()
            .filter(Employee::isHighPerformer)                 // Intermediate Operation 1: Filter high performers
            .map(e -> new Employee(e.getName(), e.getAge(), e.getSalary() * 1.1, e.isHighPerformer())) // Intermediate Operation 2: Map to increase salary by 10%
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // Intermediate Operation 3: Sort by salary descending
            .limit(3)                                            // Intermediate Operation 4: Limit to top 3
            .collect(Collectors.toList());                       // Terminal Operation: Collect to a list

        System.out.println("Top 3 High-Performing Employees with Updated Salaries:");
        topPerformers.forEach(System.out::println);
    }
}
