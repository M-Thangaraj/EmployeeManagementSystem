package employee;
import java.util.*;

abstract class employeeId extends employeeName{
	
  static String eid;
  public static void setEmployeeId(String eids)
  {
	  EmployeeDetails.alist.add(eids);
  }
  public static boolean employeeIdCheck(String employeeid)
  {
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
  public static void employeeIds()
  { 
      Scanner sc= new Scanner(System.in);
      System.out.println("Enter the Employee Id");
      System.out.println("Employee Id should be in ACE1234 in this format");
      String employeeid = sc.nextLine();
      boolean bool = employeeIdCheck(employeeid);
      if(!bool)
      {
          System.out.println("Employee id doesn't match the given format");
          employeeIds();
      }
      else
      {
    	  
    	  setEmployeeId(employeeid);
      }
  }

  
}

