import java.util.*;
import java.util.stream.Collectors;

class Employee {
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

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public String toString() {
        return id + " - " + name + " - " + department + " - $" + salary;
    }
}

public class EmployeeDataProcessing {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(101, "Alice", "Engineering", 90000),
                new Employee(102, "Bob", "Engineering", 85000),
                new Employee(103, "Charlie", "HR", 70000),
                new Employee(104, "Dave", "Engineering", 75000),
                new Employee(105, "Eve", "Finance", 95000)
        );

        // Step 1: Filter employees in Engineering department with salary > 80,000
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getDepartment().equals("Engineering") && emp.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println("Filtered & Sorted Employees:");
        filteredEmployees.forEach(System.out::println);

        // Step 2: Group employees by department
        Map<String, List<Employee>> groupedEmployees = filteredEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nGrouped Employees:");
        groupedEmployees.forEach((department, list) -> {
            System.out.println(department + ": " + list);
        });

        // Step 3: Aggregate average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("\nAverage Salary by Department:");
        avgSalaryByDept.forEach((dept, avgSalary) -> System.out.println(dept + ": $" + avgSalary));
    }
}