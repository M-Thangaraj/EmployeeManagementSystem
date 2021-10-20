package employee;
import java.util.Scanner;
abstract class insertEmployees {
	static Scanner sc = new Scanner(System.in);
	public static void insertEmployee() {
		 System.out.println("Insert Employee details");
		 int num =1;
		 do
		 {
			 System.out.println("Enter the Employee Details");
			 EmployeeDetails.employeeIds();
			 EmployeeDetails.employeeNames();
			 EmployeeDetails.employeeMailIds();
			 EmployeeDetails.employeeDobs();
			 EmployeeDetails.employeeDojs();
				 //employeeDepartment();
			 System.out.println("Enter 0 to Home or 1 to go Dashboard");
			 num =sc.nextInt();
		 }while(num>0);
		 EmployeeDetails.employeeDatabase();
	}

}
