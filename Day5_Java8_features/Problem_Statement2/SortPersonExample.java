import java.util.List;
import java.util.Comparator;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() { return name + " - Age: " + age + " - Salary: $" + salary; }
}

public class SortPersonExample {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 30, 70000),
                new Person("Bob", 25, 60000),
                new Person("Charlie", 35, 80000)
        );

        people.stream()
                .sorted(Comparator.comparingInt(p -> p.age))
                .forEach(System.out::println);
    }
}