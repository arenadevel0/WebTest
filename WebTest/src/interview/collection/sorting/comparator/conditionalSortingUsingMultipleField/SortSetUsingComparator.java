package interview.collection.sorting.comparator.conditionalSortingUsingMultipleField;

import interview.collection.dto.comparator.Department;
import interview.collection.dto.comparator.Employee;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SortSetUsingComparator {

	public static void main(String[] args) {
		Set<Employee> employeeSet = new TreeSet<Employee>(new EmployeeComparator());
		employeeSet.add(new Employee(1,"ABC", 25, 70000F, new Department(100, "IT")));
		employeeSet.add(new Employee(2,"DEF", 21, 40000F, new Department(100, "IT")));
		employeeSet.add(new Employee(3,"GHI", 28, 120000F, new Department(100, "IT")));
		employeeSet.add(new Employee(4,"JKL", 24, 60000F, new Department(100, "IT")));
		employeeSet.add(new Employee(5,"MNO", 31, 150000F, new Department(100, "IT")));
		employeeSet.add(new Employee(6,"PRQ", 20, 35000F, new Department(100, "IT")));
		employeeSet.add(new Employee(7,"STU", 23, 50000F, new Department(100, "IT")));
		employeeSet.add(new Employee(8,"VXY", 28, 123000F, new Department(100, "IT")));
		employeeSet.add(new Employee(9,"ZAB", 24, 65000F, new Department(100, "IT")));
		employeeSet.add(new Employee(10,"CDE", 28, 120000F, new Department(100, "IT")));
		
		for (Iterator<Employee> iterator = employeeSet.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
		}
		
	}

}
