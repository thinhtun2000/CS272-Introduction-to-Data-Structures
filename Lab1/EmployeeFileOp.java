package cs272program;

import java.io.*;
import java.util.*;

class employee {
 	String employeeName;
	String employeeNumber;
	String state;
	String zip;
	String age;
	String sex;
	
	public void print()
	{
		System.out.printf("%s %s %s %s %s %s\n", employeeName, employeeNumber, state, zip, age, sex);
	}
}

public class EmployeeFileOp {
	private static ArrayList<employee> ArrayEmp = new ArrayList<employee>();
	
	public static void read(String fname){
		String line = "";
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	employee e = new employee();
                //parse line
            	int quote = line.indexOf('\"', line.indexOf('\"')+1);
				int idx = quote == -1 ? line.indexOf(',') : line.indexOf('\"', line.indexOf('\"')+1)+1;
				String name = line.substring(0, idx);
				e.employeeName = name;
				String[] temp = line.substring(idx+1).split(",", 7);
				
				e.employeeNumber = temp[0];
				e.state = temp[1];
				e.zip = temp[2];
				e.age = temp[4];
				e.sex = temp[5];
				
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
	
	public static void write (String fname) {
		try {
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			int i = 0;
			bw.write(ArrayEmp.get(i).employeeName+","+ArrayEmp.get(i).employeeNumber+","+ArrayEmp.get(i).state+","+ArrayEmp.get(i).zip+","+ArrayEmp.get(i).age+","+ArrayEmp.get(i).sex+",\n");
			for(i=1;i<ArrayEmp.size()-1;i++){
				if (Integer.parseInt(ArrayEmp.get(i).age) <= 30 )
					bw.write(ArrayEmp.get(i).employeeName+","+ArrayEmp.get(i).employeeNumber+","+ArrayEmp.get(i).state+","+ArrayEmp.get(i).zip+","+ArrayEmp.get(i).age+","+ArrayEmp.get(i).sex+",\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finish writing pairs to file "+ fname);
	}
	
	public static void main(String[] args) {
		read("core_dataset.csv");
		write("young_employee.csv");
		for (int i = 0; i < ArrayEmp.size(); ++i) {
			ArrayEmp.get(i).print();
		}
	}
	

}
