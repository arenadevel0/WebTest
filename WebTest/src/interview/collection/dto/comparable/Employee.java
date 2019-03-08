package interview.collection.dto.comparable;

/* Here I'm taking states types primitive, since we are doing it with Comparable so better to write logic instead of using compareTo(Object o1, Object o2) method
 * of Comparable on states by declaring them as wrapper. Anyhow we can also make states wrapper but our purpose here is to define and explain the logic of sorting 
 * in Comparable*/

public class Employee implements Comparable<Employee>{

	private int empId;
	private String name;
	private int age;
	private float salary;
	private Department dept;
	
	
	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}
	/**
	 * @return the dept
	 */
	public Department getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public Employee(int empId, String name, int age, float salary,
			Department dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.dept = dept;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + ", dept=" + dept + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + empId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (empId != other.empId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		return true;
	}
	
	/**
	 * Objective : Here we are comparing on basis of age and for equal age second
	 * comparison is done on salary basis and for equal salary third comparison is
	 * done on basis of name
	 **/
	
	@Override
	public int compareTo(Employee o) {
		if(this.age>o.age)
			return 1;
		else if(this.age<o.age)
			return -1;
		else if(this.age==o.age){
			if(this.salary>o.salary)
				return 1;
			else if(this.salary<o.salary)
				return -1;
			else if(this.salary==o.salary){
				return this.name.compareTo(o.name);
			}
		}
		return 1;		
	}
}
