

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//Implement an Employee Management System with these features:
//- The Employee class will have these data members:
//private int id;
//private String lastName;
//private String firstName;
//private Department department;
//- Department is an enumeration of:
//ACCOUNTING
//HR
//DEVELOPMENT
//SALES
//- Use a Map collection to store the employees with the key: id
//
//- the system will display a menu with options from 1 to 5 to
//ADD, REMOVE an employee, MODIFY the Department of an employee,
//PRINT the list of employees sorted by id, and EXIT.
//1. ADD
//2. REMOVE
//3. MODIFY
//4. PRINT
//5. EXIT
//- After completing the menu actions 1 to 4, the system will display
//the menu again, until EXIT (menu option 5), which will terminate the program.
//

public class EmployeeOperations {
		 	 
         Scanner scan = new Scanner(System.in);
         TreeMap<Integer, Employee> EmployeeData = new TreeMap<Integer, Employee>(); 
		 
         public void ARMPE() {
		
         System.out.println("\n1.ADD\n2.REMOVE\n3.MODIFY\n4.PRINT\n5.EXIT");
		
    
		System.out.println("Please choose an Option from 1 - 5:"+"\n");
		
		try {
			
		int num = scan.nextInt();
	
		if(num > 5 || num < 5) {
     
		 switch (num) {
	        case 1:
	        	
	        	AddEmployee();
	        	break;
	        	
	        case 2: 
	        	
	           RemoveEmployee();
	           break;
	           
	        case 3:
	        	
	        	ModifyEmployee();
	        	break;
	           
	        case 4: 
	        	PrintEmployee();
	        	break;
	        	
	        case 5: 
	        	ExitSystem();
	        	break;
	        default:
	        	System.out.println("Please enter a number from 1-5 only.");
	        	
			}
		
		 }
		 
		}catch(InputMismatchException e) {
			
			System.out.println("Please enter a number only.\nPlease try again.");	
			
		}
		
	
		
         }
 	
     
         
         public void AddEmployee() {
        	 
        	 
     		Employee employee = new Employee();
     		
  	
     		System.out.println("Enter an ID:");
     		employee.setId(scan.nextInt());
     		
     		if(EmployeeData.containsKey(employee.getId())) {
    			System.out.println("Employee ID [" + employee.getId() + "] already exists!");
    			System.out.println("Please enter unique employee ID.");
    			
    			ARMPE();
    			}
     		
     		else {
     			
     			
     		System.out.println("Enter First Name:");
     		employee.setFirstName(scan.next());
			
			System.out.println("Enter Last Name:");
			employee.setLastName(scan.next());
			
		System.out.println("1.ACCOUNTING\n2.HR\n3.DEVELOPMENT\n4.SALES");
		employee.setDepartment(Department.values()[scan.nextInt()-1]); // get value of department in enums and store the data in employee
		EmployeeData.put(employee.getId(), employee);//use treeMap to store data(the Id, firstname, lastname and department data.
     	
		System.out.println("Employee Added successfully!\n" + EmployeeData.get(employee.getId()));
         
		ARMPE(); //Return to ARMPE method
     		}
  
         }
         
         private void RemoveEmployee() {
        	
        	 System.out.println("Enter an employee ID to remove:");
     		int EmployeeId = scan.nextInt();
     		
     		if(EmployeeData.get(EmployeeId)!=null) {
    			System.out.print("An employee record removed successfully!\n"+EmployeeData.get(EmployeeId));
    			EmployeeData.remove(EmployeeId); //Remove the employee from the Tree Map
    		}else {
    			System.out.println("The Employee ID [" + EmployeeId + "] does not exist!");
    		}
    		
    		ARMPE(); //Return to ARMPE method
    	}
         
         
         private void PrintEmployee() {
        	 
        		System.out.println("List of current employees:");
        		
        		//First check to see if any employees exist in the map
        		if(EmployeeData.isEmpty()) {
        			System.out.println("[The Employee List is Empty]");
        		}else {
        			//For every map entry in the Tree Map, print to a new line
        			for(Map.Entry<Integer,Employee> x:EmployeeData.entrySet()) {
        			System.out.println(x.getValue());
        			}
        		}
        		
        		ARMPE();
         }
         
         private void ModifyEmployee() {
        	 
        	 Employee employee = new Employee();
        	 
        	 System.out.println("Enter an Employee ID: ");
        	 int employeeID = scan.nextInt();// to read ID input
        	 
        	 employee = EmployeeData.get(employeeID); //to store employee ID to modify in tree map
        	 
        	 if(EmployeeData.get(employeeID)!=null) {
     			System.out.println("Employee ID Found! [" + employeeID + "]!");
        	 
        	 System.out.println("1.ACCOUNTING\n2.HR\n3.DEVELOPMENT\n4.SALES");
     		employee.setDepartment(Department.values()[scan.nextInt()-1]); // get value of department in enums and store the data in employee
     		EmployeeData.replace(employee.getId(), employee);
        	
     		System.out.print("Employee Department changed successfully!\n"+EmployeeData.get(employeeID)+"\n");
        	 	 
        	 
         }
        	 
         else {
     			System.out.println("The Employee ID [" + employeeID + "] does not exist!");
     		  }
        	 
        	 ARMPE();
        	 
         }
         
         public void ExitSystem() {
        	 
        	 System.out.println("Thank you for using Employee management system!");
        	 
        	 
         }
         
         
         
         
}
               







	      
	    
	

