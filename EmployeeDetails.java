package employee;

import java.util.ArrayList;
import java.util.Scanner;

class EmployeeDetails extends employeeId
{
	 static Scanner sc = new Scanner(System.in);
	public static ArrayList<String> alist = new ArrayList<>();
	 public static void employeeDatabase() {
		 int choice;
		 System.out.println("Employement Management System..");
		 do {
			 System.out.println("Enter your choice\n1.Insert Employee\n2.Delete Employee\n3.Update Employee\n4.Display\n5.Exit\n");
			 choice = sc.nextInt();
			 switch(choice)
			 {
			 case 1:
				 insertEmployee();
			 case 2:
				 deleteEmployee();
				 break;
			 case 3:
				 updateEmployee();
				 break;
			 case 4:
				 displays();
				 break;
			 case 5:
				 System.out.println("Exiting........");
				 System.exit(0);
		     default:
		    	 System.out.println("Enter the valid choice");	 
			 }
			 System.out.println("Enter 1 to go to Home '0' to exit");
			 choice = sc.nextInt();
		 }while(choice>0);
	 }
}