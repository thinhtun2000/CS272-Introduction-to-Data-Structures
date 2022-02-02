
public class Employee {
	
	// Declare some insctances
	String name;
	int number;
	int age;
	String state;
	int zip;
	int [] advisors = new int[3]; // each employee can have at most 3 advisors
	
	// No-argument constructor sets null to all non-primitive and 0 to all primitive variables
	public Employee () {
		name = null;
		number = 0;
		age = 0;
		state = null;
		zip = 0;
		advisors = null;
	} // end of constructor
	
	// Copy constructor
	public Employee (Object obj) {
		if ((obj != null) && (obj instanceof Employee)) {
			Employee emp = (Employee) obj;
			this.name = new String(emp.name);
			this.number = emp.number;
			this.age = emp.age;
			this.state = new String(emp.state);
			this.zip = emp.zip;
			this.advisors = emp.advisors;
		}
	} // end of constructor
	
	// Get & Set methods
	public String getName () {
		return name;
	}
	
	public int getNumber () {
		return number;
	}
	
	public int getAge () {
		return age;
	}
	
	public String getState () {
		return state;
	}
	
	public int getZip () {
		return zip;
	}
	
	public int[] getAdvisors () {
		return advisors; 
	}
	
	public void setName (String n) {
		name = n;
	}
	
	public void setNumber (int num) {
		number = num;
	}
	
	public void setAge (int a) {
		age = a;
	}
	
	public void setState (String s) {
		state = s;
	}
	
	public void setZip (int z) {
		zip = z;
	}
	
	public void setAdvisors (int[] adv) {
		advisors = adv;
	}
	
	// toString method that generates a string representation of an employee
	public String toString(Employee emp) {
		String advisors = "";
		for (int i = 0; i < 3; i++) {
			advisors += Integer.toString(emp.advisors[i]) + " ";
		}
		return this.name + ", " + this.number + ", " + this.age + ", " + this.state + ", " + this.zip + ", " + advisors; 
	} // end of method
	
	//toString method for displaying advisors (for testing purpose only)
	public String toString( int [] advs ) {
		String advisors = "";
		for (int i = 0; i < 3; i++) {
			advisors += Integer.toString(advs[i]) + " ";
		}
		return advisors;
	} // end of method
	
	// equals method
	public boolean equals (Object obj) {
		if ((obj != null) && (obj instanceof Employee)) {
			Employee candidate = (Employee) obj;
			return (candidate.number == number);
		}
		else
			return false;
	} // end of method
	
	// a static method that will get all the advisors of 2 employees
	public static int[] getAllAdvisors (Employee e1, Employee e2) {
		int [] allAdvisors = new int[6];
		int count = 0;
		if ((e1 != null) && (e2 != null)) {
			for (int i = 0; i < 3; i++) {
				allAdvisors[i] = e1.advisors[i];
				count++;
			}	
			for (int i = 0; i < 3; i++) {
				if (e2.advisors[i] != allAdvisors[i]) {
					allAdvisors[count] = e2.advisors[i];
					count++;
				}
			}
		}
		return allAdvisors;
	} // end of method
	
	/*
	// main() method to test the code
	public static void main(String[] args) {
		
		// create an object of the class Employee
		Employee employee1 = new Employee();
		
		// create some array for advisors
		int[] advisors1 = {1, 2, 3};
		int[] advisors2 = {1, 5, 4};
		int[] advisors3 = {4, 5, 6};
		
		// set the values of all variable of employee1
		employee1.setName("Harry Potter");
		employee1.setNumber(13);
		employee1.setAge(21);
		employee1.setState("NM");
		employee1.setZip(88003);
		employee1.setAdvisors(advisors1);
		
		// test the set methods and the toString method
		System.out.println(employee1.toString(employee1));
		
		// create a new object by copying from employee1
		Employee employee2 = new Employee(employee1);
		System.out.println(employee2.getName());
		System.out.println(employee2.getNumber());
		System.out.println(employee2.getAge());
		System.out.println(employee2.getState());
		System.out.println(employee2.getZip());
		System.out.println(employee2.toString(employee2.getAdvisors()));
		
		// Change the employee2 number and then compare
		employee2.setNumber(15);
		if (employee2.equals(employee1)) {
			System.out.println("2 employees are the same.");
		}
		else
			System.out.println("2 employees are different.");
		
		// Create another employee3 that has the same info with employee1
		Employee employee3 = new Employee(employee1);
		// Compare
		if (employee3.equals(employee1)) {
			System.out.println("2 employees are the same.");
		}
		else
			System.out.println("2 employees are different.");
		
		// Change advisors of employee 2 and 3
		employee2.setAdvisors(advisors2);
		employee3.setAdvisors(advisors3);
		
		// Compare the advisors
		int[] arrayAdvisors = getAllAdvisors (employee1, employee2);
		
		
		// Print the results
		for (int i = 0; i < 6; i++) {
			if (arrayAdvisors[i] != 0) {
				System.out.print(arrayAdvisors[i] + " ");
			}
		}
		System.out.println();
		
		arrayAdvisors = getAllAdvisors (employee1, employee3);
		for (int i = 0; i < 6; i++) {
			if (arrayAdvisors[i] != 0) {
				System.out.print(arrayAdvisors[i] + " ");
			}
		}
		System.out.println();
	}
	*/
}

