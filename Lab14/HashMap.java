package lab14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HashMap {
	
	private static ArrayList<Employee> ArrayEmp = new ArrayList<Employee>();
	
	public static void read(String fname){
		String line = "";
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	Employee e = new Employee();
                //parse line
            	int quote = line.indexOf('\"', line.indexOf('\"')+1);
				int idx = quote == -1 ? line.indexOf(',') : line.indexOf('\"', line.indexOf('\"')+1)+1;
				String name = line.substring(0, idx);
				e.name = name;
				String[] temp = line.substring(idx+1).split(",", 7);
				
				temp[0] = Integer.toString(e.number);
				
				ArrayEmp.add(e);	
            }   
            bufferedReader.close(); // Always close files.         
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        } 
		System.out.println("Finish reading pairs from file "+ fname);
	}

	public static void main (String[] args) {
		
		EmployeeTable table = new EmployeeTable();
		
		for (int i = 0; i < ArrayEmp.size(); ++i) {
			table.put(ArrayEmp.get(i));
		}
	}
	
}
