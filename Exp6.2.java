import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println(name);
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 80),
            new Student("Bob", 72),
            new Student("Charlie", 90),
            new Student("David", 65),
            new Student("Eve", 85),
            new Student("Bob", 70),
            new Student("Frank", 65),
            new Student("Alice", 80),
            new Student("Bob", 80),
            new Student("Charlie", 85),
            new Student("Alice", 60),
            new Student("Bob", 50),
            new Student("Charlie", 90)
        );

        List<Student> filteredSortedStudents = students.stream()
            .filter(s -> s.marks > 75) // Filter students who scored above 75%
            .sorted(Comparator.comparingDouble((Student s) -> -s.marks) // Sort by marks (descending)
                    .thenComparing(s -> s.name)) // Sort by name if marks are the same
            .collect(Collectors.toList());

        if (filteredSortedStudents.isEmpty()) {
            System.out.println("No output (Empty List)");
        } else {
            filteredSortedStudents.forEach(Student::display);
        }
    }
}
