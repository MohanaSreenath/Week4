import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary;
    }
}

public class EmployeeSerialization {

    public static void serializeEmployees(List<Employee> employees, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing employees: " + e.getMessage());
        }
    }

    public static List<Employee> deserializeEmployees(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing employees: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(101, "Alice", "HR", 50000),
                new Employee(102, "Bob", "IT", 60000),
                new Employee(103, "Charlie", "Finance", 55000)
        );

        String fileName = "employees.dat";

        serializeEmployees(employees, fileName);

        List<Employee> deserializedEmployees = deserializeEmployees(fileName);
        System.out.println("Deserialized Employees:");
        deserializedEmployees.forEach(System.out::println);
    }
}