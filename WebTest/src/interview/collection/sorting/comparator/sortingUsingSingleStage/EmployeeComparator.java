package interview.collection.sorting.comparator.sortingUsingSingleStage;

import interview.collection.dto.comparator.Employee;

import java.util.Comparator;

/**
 * Objective : Here we are comparing on basis of age
 **/

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		if(employee1.getAge() > employee2.getAge())
			return 1;
		else 
			return -1;
	}

	
}
