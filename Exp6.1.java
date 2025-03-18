import java.util.*;

// Step 1: Create the Employee Class
class Employee {
    String name;
    int age;
    double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Display method
    public void display() {
        System.out.println(name + " (" + age + ", " + salary + ")");
    }
}

// Step 2: Main Class
public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        // Sample Employee Data
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));
        employees.add(new Employee("Alex", 28, 45000));
        employees.add(new Employee("Alex", 32, 47000));
        employees.add(new Employee("Alex", 25, 46000));
        employees.add(new Employee("David", 29, 50000));
        employees.add(new Employee("Eve", 31, 50000));
        employees.add(new Employee("Frank", 27, 50000));

        // Sorting by Name (Alphabetical order)
        System.out.println("Sorting by Name:");
        employees.stream()
                 .sorted(Comparator.comparing(e -> e.name))
                 .forEach(Employee::display);
        System.out.println();

        // Sorting by Age (Ascending order)
        System.out.println("Sorting by Age:");
        employees.stream()
                 .sorted(Comparator.comparingInt(e -> e.age))
                 .forEach(Employee::display);
        System.out.println();

        // Sorting by Salary (Descending order)
        System.out.println("Sorting by Salary:");
        employees.stream()
                 .sorted(Comparator.comparingDouble(e -> -e.salary))
                 .forEach(Employee::display);
        System.out.println();

        // Edge Case - Same Name, Different Age
        System.out.println("Sorting by Name, then Age:");
        employees.stream()
                 .sorted(Comparator.comparing((Employee e) -> e.name)
                 .thenComparingInt(e -> e.age))
                 .forEach(Employee::display);
        System.out.println();

        // Edge Case - Same Salary
        System.out.println("Sorting by Salary, then Name:");
        employees.stream()
                 .sorted(Comparator.comparingDouble((Employee e) -> e.salary)
                 .thenComparing(e -> e.name))
                 .forEach(Employee::display);
    }
}
