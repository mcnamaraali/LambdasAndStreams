import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ProcessingEmployees {

	public static void main(String[] args) {
		Employee[] employees = {
				new Employee("Ali", "Mc", 4000, "IT"),
				new Employee("Tony", "Rob", 500000, "Marketing"),
				new Employee("James", "Allen", 500000, "Sales"),
				new Employee("Napoleon", "Hill", 50000000, "HR")
		};

		List<Employee> list = Arrays.asList(employees);

		System.out.println("Complete Employee List");
		
		list.stream()
			.forEach(System.out::println);

		Predicate<Employee> fourToSixThousand =
				e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);
				//Employee::getSalary(); //Classname::InstanceMethod - Classname.method()
		System.out.println("Employees earning ... ");

		list.stream()
			.filter(fourToSixThousand)
			.sorted(Comparator.comparing(Employee::getSalary))
			.forEach(System.out::println);

		System.out.printf("%nFirst employee who earns... %n%s%n",
				list.stream()
					.filter(fourToSixThousand)
					.findFirst() //short circuiting findFirst is a terminal operation
					.get());
		
		//function for getting employee first and last names from an employee
		Function<Employee, String> byFirstName = Employee::getFirstname;
		Function<Employee, String> byLastName = Employee::getLastname;
		
		Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);
		//thenComparing to create a composed Comparator that first compares lastname then first
		
		System.out.printf("%nEmployees in ascending order by last name then first: %n");
		
		list.stream()
			.sorted(lastThenFirst)
			.forEach(System.out::println);
		
		System.out.printf("%nEmployees in desc order by last name first: %n");
		
		list.stream()
			.sorted(lastThenFirst.reversed())
			.forEach(System.out::println);
		
		System.out.printf("%nEmployees in desc order by last name first: %n");
		
		list.stream()
			.map(Employee::getLastname)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		
		System.out.printf("%nEmployees in last name then first name: %n");
		
		list.stream()
			.sorted(lastThenFirst)
			.map(Employee::getName)
			.sorted()
			.forEach(System.out::println);
		
		System.out.printf("%nEmployees by department%n");
		
		Map<String, List<Employee>> groupedByDepartment =
				list.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment));
		
		groupedByDepartment.forEach((department, employeesInDepartment) -> {
				
				System.out.printf("%n%s%n", department);
				
				employeesInDepartment.forEach(
						employee -> System.out.printf("    %s%n", employee));
			}
		);
		
		System.out.printf("%Count of the employees BY department");
		
		Map<String, Long> employeeCountByDepartment =
				list.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		
		employeeCountByDepartment.forEach(
				(department,count) -> System.out.printf("%s has %d employee(s)%n", department, count));
		
		
		System.out.printf("%Sum of Employees' salaries using the Sum method %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.sum());
		
		System.out.printf("%Sum of Employees' salaries using the reduce method %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.reduce(0, (value1, value2) -> value1 + value2));
		
		System.out.printf("Average %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.average()
					.getAsDouble());
		
				
		
				
	}

}
