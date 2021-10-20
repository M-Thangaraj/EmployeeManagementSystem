package employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class updateEmployees extends insertEmployees{
	static Scanner sc = new Scanner(System.in);
	static String employeeid;
	static String employeename;
	static String mail_id;
	static String employee_dob;
	static String employee_doj;
	public static ArrayList<String> blist = new ArrayList<>();
	public static boolean employeeIdCheck(String employeeid)
    {
		System.out.println(employeeid);
		char[] employeeArray = employeeid.toCharArray();
		if(employeeArray[0] !='A'|| employeeArray[1] !='C'||employeeArray[2]!='E')
		{
			return false;
		}
		int len = employeeArray.length-3;
		if(len != 4)
		{
			return false;
		}
		for(int i = 3;i < employeeArray.length;i++)
		{
			char ch = employeeArray[i];
			if (!(ch >= '0' && ch <= '9')) 
			{
				return false;
			}
		}
		return true;
    }
	public static boolean  employeeNameCheck(String employeename)
	{
		System.out.println(employeename);
		employeename = employeename.toLowerCase();
		char[] employeeArray = employeename.toCharArray();
		for(int i = 0;i < employeeArray.length;i++)
		{
			char ch = employeeArray[i];
			if (!(ch >= 'a' && ch <= 'z')) 
			{
				return false;
			}
		}
		for(int i = 0;i < employeeArray.length;i++)
    	{
      		for(int j=i+1;j < employeeArray.length;j++)
      		{
        		if(employeeArray[i]==employeeArray[j])
        		{
          			return false;
        		}
      		}
    	}
		return true; 
	}
	public static boolean mailIdCheck(String mail_id)
	{
		String emailPattern = "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*";
		Pattern p = Pattern.compile(emailPattern);
		Matcher m = p.matcher(mail_id);
		return m.matches();
    //return Pattern.matches("[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*", mail_id);


	}
	public static void employeeId1()
	{
		System.out.println("Enter the Employee Id");
		System.out.println("Employee Id should be in ACE1234 in this format");
		employeeid = sc.next();
		boolean bool = employeeIdCheck(employeeid);
		if(!bool)
		{
			System.out.println("Employee id doesn't match the given format");
			employeeId1();
		}
		else
		{
			blist.add(employeeid);
		}
	}
	public static void employeeName1()
	{
		System.out.println("Enter the Employee Name");
		employeename = sc.next();
		boolean bool = employeeNameCheck(employeename);
		if(!bool)
		{
			System.out.println("Employee name must contain only alphabets.Retype the employee name");
			employeeName1();
		}
		else
		{
			blist.add(employeename);
		}
	}
	public static void employeeMailId1()
	{
		System.out.println("Enter the Employee's Mail Id");
		mail_id= sc.next();
		boolean bool = mailIdCheck(mail_id);
		if(!bool)
		{
			System.out.println("The given mail id is not valid");
			employeeMailId1();
		}
		else
		{
			blist.add(mail_id);
		}
	}
	public static void employeeDob1()
	{
		System.out.println("Enter the employee Date of birth:");
		employee_dob = sc.nextLine();
		SimpleDateFormat empdob = new SimpleDateFormat("dd/MM/yyyy");
		empdob.setLenient(false);
		try
		{
			Date valid_dob = empdob.parse(employee_dob);
			long date_diff = System.currentTimeMillis() - valid_dob.getTime();
			long age = (long)((long)date_diff/(1000.0*60*60*24*365));	  				  				
			if(age>=18 && age<=60)
			{
				blist.add(employee_dob);
				return;
			}	  					
			else
			{
				System.out.printf("Please enter valid date - format (DD:MM:YYYY)\n Age should be between 18 to 60");
				employeeDob1();
			}
		}
		catch(ParseException exception)			  			
		{
			System.out.println("Please enter valid date - format (DD:MM:YYYY)\\n Age should be between 18 to 60");
			employeeDob1();
		}	
	}
	public static void employeeDoj1()
	{ 
	 	System.out.println("Enter the employee Date of joining:");
	 	employee_doj = sc.nextLine();
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
				blist.add(employee_doj);
				return;				
			}
			else
			{
				System.out.printf("Please enter valid date - format (DD/MM/YYYY) Date of joining should not be future date");
				employeeDoj1();
			}
		}
		catch(ParseException exception)			  			
		{
			System.out.println("Please enter valid date - format (DD/MM/YYYY) Date of joining should not be future date");
			employeeDoj1();
		}		
	}
 public static void updateEmployee() {
	 System.out.println("Enter the Employee Id to update");
	 String empID = sc.next();
	 int firstindex = EmployeeDetails.alist.indexOf(empID);
	 int lastindex = firstindex+5;
	 try {
		 employeeId1();
		 employeeName1();
		 employeeMailId1();
		 employeeDob1();
		 employeeDoj1();
		 EmployeeDetails.alist.subList(firstindex,lastindex).clear();
		 EmployeeDetails.alist.addAll(firstindex, blist);
	 }
	 catch(IndexOutOfBoundsException exception)
	 {
		 System.out.println("Entered Employement ID is not available!!");
		 System.out.println("Please enter the valid Employement ID");
		 updateEmployee();
	 }
 }

}
