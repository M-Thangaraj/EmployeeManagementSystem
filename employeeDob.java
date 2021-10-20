package employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
abstract class employeeDob extends employeeDoj{
    static String edob,emob,eyob;
    public static void setEmployeeDob(String eDobs)
    {
    	EmployeeDetails.alist.add(eDobs);
    }
	public static void employeeDobs()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee Date of birth:");
		String employee_dob = sc.nextLine();
		SimpleDateFormat empdob = new SimpleDateFormat("dd/MM/yyyy");
		empdob.setLenient(false);
		try
		{
			Date valid_dob = empdob.parse(employee_dob);
			long date_diff = System.currentTimeMillis() - valid_dob.getTime();
			long age = (long)((long)date_diff/(1000.0*60*60*24*365));	  				  				
			if(age>=18 && age<=60)
			{
				setEmployeeDob(employee_dob);
			}	  					
			else
			{
				System.out.printf("Please enter valid date - format (DD:MM:YYYY)\n Age should be between 18 to 60");
				employeeDobs();
			}
		}
		catch(ParseException exception)			  			
		{
			System.out.println("Please enter valid date - format (DD:MM:YYYY)\\n Age should be between 18 to 60");
			employeeDobs();
		}	
	}
}