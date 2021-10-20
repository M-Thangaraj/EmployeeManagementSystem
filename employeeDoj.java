package employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
abstract class employeeDoj extends display{
    static String edoj,emoj,eyoj;
    public static void setEmployeeDoj(String eDojs)
    {
    	EmployeeDetails.alist.add(eDojs);
    }
	public static void employeeDojs()
	{ 
		Scanner sc = new Scanner(System.in);
	 	System.out.println("Enter the employee Date of joining:");
	 	String employee_doj = sc.nextLine();
		SimpleDateFormat empdoj = new SimpleDateFormat("dd/MM/yyyy");
		empdoj.setLenient(false);
		try
		{		  				
			Date valid_doj = empdoj.parse(employee_doj);
			long date_diff = System.currentTimeMillis() - valid_doj.getTime();
			TimeUnit time = TimeUnit.DAYS;
			long difference = time.convert(date_diff,TimeUnit.MILLISECONDS);	  				
			if(difference>0)
			{
				setEmployeeDoj(employee_doj);				
			}
			else
			{
				System.out.printf("Please enter valid date - format (DD/MM/YYYY) Date of joining should not be future date");
				employeeDojs();
			}
		}
		catch(ParseException exception)			  			
		{
			System.out.println("Please enter valid date - format (DD/MM/YYYY) Date of joining should not be future date");
			employeeDojs();
		}		
	}
}