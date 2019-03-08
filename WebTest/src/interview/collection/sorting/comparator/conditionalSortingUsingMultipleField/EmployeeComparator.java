package interview.collection.sorting.comparator.conditionalSortingUsingMultipleField;

import interview.collection.dto.comparator.Employee;

import java.util.Comparator;

/**
 * Objective : Here we are comparing on basis of age and for equal age second
 * comparison is done on salary basis and for equal salary third comparison is
 * done on basis of name
 **/

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {

		int ageComparator = employee1.getAge().compareTo(employee2.getAge());

		if (0 == ageComparator) {
			int salaryComparator = employee1.getSalary().compareTo(
					employee2.getSalary());
			if (0 == salaryComparator)
				return employee1.getName().compareTo(employee2.getName());
			return salaryComparator;
		}
		return ageComparator;

	}

}
