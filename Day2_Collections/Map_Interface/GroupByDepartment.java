import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee employee : employees) {
            grouped.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee);
        }
        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee("Alice", "HR"), new Employee("Bob", "IT"), new Employee("Carol", "HR"));
        System.out.println("Grouped Employees: " + groupByDepartment(employees));
    }
}
