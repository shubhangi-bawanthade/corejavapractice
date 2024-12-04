package StreamPractice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice2 {

	public static void main(String[] args) {
		List<Employee> employeesList = employeesList();
		Stream<Employee> employeeStream = employeesList.stream();

		List<String> list = employeeStream.map(e -> e.getName()).toList();
		System.out.println(list);

		employeesList.stream().map(e -> e.getName()).forEach(System.out::println);
		System.out.println("------------------------------");

		List<String> list2 = employeesList.stream().filter(e -> e.getAge() > 25).map(e -> e.getName()).toList();
		System.out.println(list2);

		System.out.println("------------------------------");

		System.out.println("distinct city");

		employeesList.stream().map(e -> e.getCity()).distinct().forEach(System.out::println);

		System.out.println("------------------------------");

		// employee cuot whese salary >20000

		long count = employeesList.stream().filter(e -> e.getSalary() > 20000).count();

		System.out.println(count);

		// dislay first employee object
		employeesList.stream().limit(3).forEach(System.out::println);

		System.out.println("------------------------------");

		// skip first 3 object

		employeesList.stream().skip(3).forEach(System.out::println);

		System.out.println("------------------------------");
		// anymatch
		boolean anyMatch = employeesList.stream().anyMatch(e -> e.getAge() < 18);

		System.out.println(anyMatch);

		System.out.println("------------------------------");
		// allmatch

		boolean allAmtch = employeesList.stream().allMatch(e -> e.getAge() > 18);

		System.out.println(allAmtch);

		System.out.println("------------------------------");
		// nonematch

		boolean noneMatch = employeesList.stream().noneMatch(e -> e.getSalary() < 9000);
		System.out.println(noneMatch);

		System.out.println("------------------------------");
		Optional<Employee> findAny = employeesList.stream().filter(e -> e.getSalary() > 15000).findAny();

		System.out.println(findAny);

		System.out.println("------------------------------");
		Optional<Employee> findFirst = employeesList.stream().filter(e -> e.getSalary() > 15000).skip(6).findFirst();

		System.out.println(findFirst);

		System.out.println("------------------------------");
		employeesList.stream().map(e -> e.getSalary()).sorted().forEach(System.out::println);

		System.out.println("------------------------------");

		employeesList.stream().sorted((e1, e2) -> {
			return e2.getId() - e1.getId();
		}).forEach(System.out::println);

		System.out.println("------------------------------");

		Employee employee = employeesList.stream().min((e1, e2) -> {
			return e1.getAge() - e2.getAge();
		}).get();

		System.out.println("min employee" + employee);

		System.out.println("------------------------------");

		Employee employee2 = employeesList.stream().min((e1, e2) -> {
			return (int) (e1.getSalary() - e2.getSalary());
		}).get();

		System.out.println("min employee" + employee2);

		System.out.println("------------------------------");

		Employee employee3 = employeesList.stream().min((e1, e2) -> {
			return (int) (e2.getSalary() - e1.getSalary());
		}).get();

		System.out.println("max employee" + employee3);

		System.out.println("------------------------------");

		double asDouble = employeesList.stream().mapToDouble(e -> e.getSalary()).average().getAsDouble();

		System.out.println("average salary : " + asDouble);

		System.out.println("------------------------------");
		double asDouble2 = employeesList.stream().mapToInt(e -> e.getAge()).average().getAsDouble();

		System.out.println("average age : " + asDouble2);

		System.out.println("------------------------------");

		employeesList.stream().peek(System.out::println).filter(e -> e.getSalary() > 20000)
				.forEach(System.out::println);

		System.out.println("---------------parallel steam---------------");

		employeesList.parallelStream().peek(System.out::println).filter(e -> e.getSalary() > 20000)
				.forEach(System.out::println);

		// Collectors

		System.out.println("---------------toSet---------------");
		Set<String> collect = employeesList.stream().map(e -> e.getDepartment()).collect(Collectors.toSet());

		System.out.println(collect);
		System.out.println("---------------tomap---------------");
		//

		Map<Integer, Double> collect2 = employeesList.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getSalary));

		System.out.println(collect2);
		System.out.println("---------------tomap---------------");

		Map<String, Double> collect3 = employeesList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(collect3);

		System.out.println("---------------tomap---------------");

		Map<String, Long> collect4 = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		System.out.println(collect4);

		System.out.println("---------------tomap---------------");

		Entry<String, Long> orElseThrow = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet().stream()
				.min(Map.Entry.comparingByValue()).orElseThrow(() -> new RuntimeException("no record found"));

		System.out.println(orElseThrow);
		//find grouping departmant by salary

		LinkedHashMap<String, Double> sordtedGroupByDepartment = employeesList.stream()
				.collect(
						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(sordtedGroupByDepartment);

		System.out.println("---------------tomap---------------");

		Double collect6 = employeesList.stream().collect(Collectors.summingDouble(Employee::getSalary));

		System.out.println(collect6);
		
		System.out.println("---------------tomap---------------");
		
		//find max age employee
		
		Employee maxageEmployee = employeesList.stream().collect(Collectors.maxBy((e1,e2)->e1.getAge()-e2.getAge())).get();
		
		System.out.println(maxageEmployee);
		
		

	}

	public static List<Employee> employeesList() {

		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee(6, "Six", 43, "Female", "Security", 2016, 9500.0, "Pune"));
		employeeList.add(new Employee(7, "Seven", 35, "Male", "Finance", 2010, 27000.0, "Pune"));
		employeeList.add(new Employee(3, "Three", 29, "Male", "Infrastructure", 2012, 18000.0, "Hyderabad"));
		employeeList.add(new Employee(8, "Eight", 31, "Male", "Development", 2015, 34500.0, "Pune"));
		employeeList.add(new Employee(9, "Nine", 24, "Female", "Sales", 2016, 11500.0, "Hyderabad"));
		employeeList.add(new Employee(10, "Ten", 25, "Female", "Sales", 2009, 22500.0, "Pune"));
		employeeList.add(new Employee(2, "Two", 25, "Male", "Sales", 2015, 13500.0, "Hyderabad"));
		employeeList.add(new Employee(4, "Four", 28, "Female", "Development", 2014, 32500.0, "Pune"));
		employeeList.add(new Employee(5, "Five", 27, "Female", "HR", 2013, 22700.0, "Pune"));
		employeeList.add(new Employee(1, "One", 32, "Female", "HR", 2011, 25000.0, "Hyderabad"));

		return employeeList;
	}

}
