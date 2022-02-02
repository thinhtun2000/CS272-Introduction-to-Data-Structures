package lab14;

public class EmployeeTable {
	
	// instance variables
	int num;
	Object[] keys;
	Object[] data;
	boolean[] used;
	
	// Constructor for EmployeeTable
	public EmployeeTable() {
		num = 0;
		keys = new Object[701];
		data = new Object[701];
		used = new boolean[701];
		for (int i = 0; i < 701; i++)
			used[i] = false;
	}
	
	// design the hash function
	private int hash(Object key) {
		return Math.abs(key.hashCode()) % data.length;
	}
	
	// Add a new employee e into the hash table
	public void put(Employee e) {
		if (num == data.length) 
			return;
		int idx = findIndex(e);
		if(idx != -1)
			data[idx] = e;
		else {
			for (idx = hash(e); idx < keys.length; idx++) {
				if(keys[idx] != null)
					idx++;
				else
					break;
			}
			keys[idx] = e.getNumber();
			data[idx] = e;
			used[idx] = true;
			num++;
		}
			
	}
	
	// The find index function
	private int findIndex (Object key) {
		int idx = hash(key);
		int counter = 0;
		while (counter < data.length && used[idx] == true) {
			if (key.equals(keys[idx])) 
				return idx;
			else
				idx++;
			counter++;
		}
		return -1;
	}
	
	// Remove a given employee with employee id emp_no from the hash table.  
	// Return false if an employee with emp_no does not exist in the hash table;
	// Otherwise, remove it and return true.
	public boolean remove(int emp_no) {
		int i = search(emp_no);
		if (i != -1) {
			keys[i] = null;
			data[i] = null;
			num--;
			used[i] = false;
			return true;
			
		}
		else
			return false;
	}
	
	// Find the index of the given employee id emp_no.  
	// Return the index of the employee in the array if the employee with the given employee no exists in the hash table;
	// Otherwise, return -1.
	public int search(int emp_no) {
		Employee e = new Employee(emp_no);
		int i = 0;
		if (num == 0)
			return -1;
		while (keys[i] != null) {
			if (keys[i].equals(e.getNumber()))
				return i;
			else
				i++;
		}
		return i;
	}
	
	// Main method to test other methods
	public static void main (String[] args) {
		
		System.out.println("Create a new Employee Table\n");
		EmployeeTable table = new EmployeeTable();
		
		// create an object of the class Employee
		System.out.println("Create 2 new employee objects\n");
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		
		// set the values of all variable of employee1
		System.out.println("Set the numbers of the 2 employee objects\n");
		employee1.setNumber(1);
		employee1.setNumber(5);
		
		// Test the put method
		table.put(employee1);
		System.out.println("The hash code of this object is: " + employee1.hashCode());
		table.put(employee2);
		System.out.println("\nThe hash code of this object is: " +employee2.hashCode());
		
		// Test the remove method
		int n = 1;
		if (table.remove(n))
			System.out.println("\nRemoved the employee with the number " + n + ".");
		else
			System.out.println("\nNo employee with the number " + n + " to remove.");
		n = 5;
		if (table.remove(n))
			System.out.println("\nRemoved the employee with the number " + n + ".");
		else
			System.out.println("\nNo employee with the number " + n + " to remove.");
		
	}
	
	
	
}
