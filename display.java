package employee;

abstract class display extends DeleteEmployee {
	 public static void displays() {
		 System.out.printf("\n------------------------------------------------------------------------------------------------\nEmployee ID\tEmployee Name\tEmail ID\t\tDate of birth\t\tDate of join\n------------------------------------------------------------------------------------------------\n");
		 int count=0;
		 for(String iterator: EmployeeDetails.alist)	
		 {
			 if(count>=5)
			 {
				 System.out.println();
				 count=0;
			 }
			System.out.print(iterator+"\t\t");
			count++;
		 } 
		 System.out.println();
	 }
}
