package employee;

abstract class DeleteEmployee extends updateEmployees {
	public static void deleteEmployee() {
		 System.out.println("Enter the Employee Id to delete");
		 String empID = EmployeeDetails.sc.next();
		 int firstindex = EmployeeDetails.alist.indexOf(empID);
		 int lastindex = firstindex+5;
		 try
		 {
			 EmployeeDetails.alist.subList(firstindex,lastindex).clear();
		 }
		 catch(IndexOutOfBoundsException exception)
		 {
			 System.out.println("Entered Employement ID is not there");
			 System.out.println("Please enter the valid Employement ID");
			 deleteEmployee();
		 }
	}
}
