import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeSet {
	
	// Declare variables
	Employee[] emp;
	int numOfEmployees;
	
	/* @postcoondition
	 * This data structure is empty and has an initial capacity of 10
	 * @exception OutOfMemoryError
	 */
	public EmployeeSet() {
		final int INITIAL_CAPACITY = 10;
		numOfEmployees = 0;
		emp = new Employee[INITIAL_CAPACITY];
	}
	
	// Copy constructor
	/* @precondition
	 * obj is not null
	 * obj is an instance of EmployeeSet
	 */
	public EmployeeSet(Object obj) {
		if ((obj != null) && (obj instanceof EmployeeSet)) {
			EmployeeSet toCopy = (EmployeeSet) obj;
			numOfEmployees = toCopy.numOfEmployees;
			emp = new Employee[numOfEmployees];
			for (int i = 0; i < numOfEmployees; i++)
				emp[i] = new Employee(toCopy.emp[i]);
		}	
	}
	
	// Method for getting size
	public int size() {
		return numOfEmployees;
	}
	
	// Method for getting capacity
	public int getCapacity() {
		return emp.length;
	}
	
	// Add method
	/* @precondition
	 * The Employee object should not be NULL
	 * @postcondition
	 * A new copy of the element has been added to this bag.
	 * @exception OutOfMemoryError
	 * Indicates insufficient memory for increasing the bag's capacity.
	 */
	public void add( Employee a ) {
		if(numOfEmployees == emp.length) {
			Employee[] biggerEmp = new Employee[(numOfEmployees + 1) * 2];
			System.arraycopy(emp, 0, biggerEmp, 0, numOfEmployees);
			emp = biggerEmp;
		}
		emp[numOfEmployees] = a;
		numOfEmployees++;
	}
	
	// Method to check if the object in the parameter is in the array
	public boolean contains( Employee a ) {
		if (a == null)
			return false;
		else
			for (int i = 0; i < emp.length; i++) {
				if (emp[i] == a)
					return true;
			}
		return false;
	}
	
	/* @postcondition: if target was in the bag, then one copy of target has been removed from the bag,
	 * and the return value is true; otherwise, the bag is unchanged and the return value is false.
	 */
	public boolean remove( int eno ) {
		int index;
		for (index = 0; (index < numOfEmployees) && (eno != index); index++);
			if (index == numOfEmployees)
				return false;
			else {
				numOfEmployees--;
				emp[index] = emp[numOfEmployees];
				return true;
			}
	}

	// Method to guarantee the capacity of the collection
	private void ensureCapacity( int minimumCapacity ) {
		Employee[] biggerEmp;
		if (emp.length < minimumCapacity) {
			biggerEmp = new Employee[minimumCapacity];
			System.arraycopy(emp, 0, biggerEmp, 0, numOfEmployees);
			emp = biggerEmp;
		}
	}
	
	// Method to check if the Employees' nos are sorted
	public boolean isSorted( Employee emp[]) {
		for (int i = 0; i < emp.length-1; i++) {
			if (emp[i].number >= emp[i+1].number)
				return false;
		}
		return true;
	}
	
	/* @precondition
	 * The Employee object should not be a null and
	 * the objects in the collection’s employee array are already in ascending order of employee nos.
	 */
	public void addOrdered( Employee a ) {
		if ((a != null) && isSorted(emp)) {
			if (numOfEmployees == emp.length)
				ensureCapacity((numOfEmployees + 1) * 2);
			emp[numOfEmployees] = a;
			numOfEmployees++;
		}
		else if (a == null)
			System.out.println("The object is null.");
		else if (isSorted(emp) == false)
			System.out.println("The Employees' nos are not sorted.");
	}
	
	// Main method to test the code
	public static void main (String [] args) {
		EmployeeSet emp = new EmployeeSet();
		
		// Create 10 employees
		Employee e1 = new Employee();
		e1.setName("Lab");
		e1.setNumber(1);
		
		Employee e2 = new Employee();
		e1.setName("Three");
		e1.setNumber(2);
		
		Employee e3 = new Employee();
		e1.setName("Is");
		e1.setNumber(3);
		
		Employee e4 = new Employee();
		e1.setName("Truely");
		e1.setNumber(4);
		
		Employee e5 = new Employee();
		e1.setName("A");
		e1.setNumber(5);
		
		Employee e6 = new Employee();
		e1.setName("Nightmare");
		e1.setNumber(6);
		
		Employee e7 = new Employee();
		e1.setName("For");
		e1.setNumber(7);
		
		Employee e8 = new Employee();
		e1.setName("CS272");
		e1.setNumber(8);
		
		Employee e9 = new Employee();
		e1.setName("Students");
		e1.setNumber(9);
		
		Employee e10 = new Employee();
		e1.setName("!!!");
		e1.setNumber(10);
		
		// Add the first 3 employees to the array
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		
		// Print the size and capacity of the array
		System.out.println("The size of the array is: " + emp.size());
		System.out.println("The capacity of the array is: " + emp.getCapacity());
		System.out.println();
		
		// Add the rest of the employees to the array
		emp.add(e4);
		emp.add(e5);
		emp.add(e6);
		emp.add(e7);
		emp.add(e8);
		emp.add(e9);
		emp.add(e10);
		
		// Print the size and capacity of the array
		System.out.println("The size of the array is: " + emp.size());
		System.out.println("The capacity of the array is: " + emp.getCapacity());
		System.out.println();
		
		// Create a new employee
		Employee e11 = new Employee();
		e11.setName("Hello");
		e11.setNumber(11);
		
		// Add e11 into the array to test if the capacity expands automatically
		emp.add(e11);
		System.out.println("The size of the array is: " + emp.size());
		System.out.println("The capacity of the array is: " + emp.getCapacity());
		System.out.println();
		
		// Create a new employee
		Employee e12 = new Employee();
		e12.setName("Hi");
		e12.setNumber(12);
		
		// Check the addOrdered method
		emp.addOrdered(e12);
		System.out.println();
		
		System.out.println("The size of the array is: " + emp.size());
		System.out.println("The capacity of the array is: " + emp.getCapacity());
		System.out.println();
		
		// Check the contains method
		if (emp.contains(e1))
			System.out.println("The EmployeeSet contains the object inserted.");
		else
			System.out.println("The EmployeeSet does not contain the object inserted.");
		
		// Remove an employee and print out the size and capacity to check
		emp.remove(1);
		System.out.println("The size of the array is: " + emp.size());
		System.out.println("The capacity of the array is: " + emp.getCapacity());
		System.out.println();
	}
}
