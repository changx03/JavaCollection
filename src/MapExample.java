import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Luke Chang on 28-Dec-16.
 */
public class MapExample {
    public class Employee {
        private String name;
        private String department;
        private int salary;

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }

        public Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public void run() {

        // Group employees by department
        List<Employee> employees = Arrays.asList(
                new Employee("Max", "HR", 33),
                new Employee("Peter", "Developer", 41),
                new Employee("Pamela", "Manager", 70),
                new Employee("Nico", "HR", 30),
                new Employee("David", "Developer", 47));
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Print nested list with flatMap()
        byDept.entrySet().stream()
                .flatMap(f -> {
                    System.out.println(f.getKey() + ": ");
                    return f.getValue().stream();
                })
                .forEach(n -> System.out.println(n.getName()));

        // Compute sum of salaries by department
        Map<String, Integer> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
        totalByDept.entrySet().forEach(e -> System.out.format("Dept: %s, Sum: %s\n", e.getKey(), e.getValue()));

        // Compute average
       double avgSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
       System.out.println(avgSalary);

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByDept);
    }

}
