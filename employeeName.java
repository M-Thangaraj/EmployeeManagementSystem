package employee;
import java.util.*;
abstract class employeeName extends employeeMail{
  static String eName;
  public static void setEmployeeName(String eNames)
  {
	  EmployeeDetails.alist.add(eNames);
  }
  public static boolean  employeeNameCheck(String employeename)
  {
      employeename = employeename.toLowerCase();
      char[] employeeArray = employeename.toCharArray();
      for(int i = 0;i < employeeArray.length;i++)
      {
          char ch = employeeArray[i];
          if(!((ch >= 'a' && ch <= 'z')||(ch>='A'&&ch<='Z'))) 
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
  public static void employeeNames()
  {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the Employee Name");
      String employeename = sc.nextLine();
      boolean bool = employeeNameCheck(employeename);
      if(!bool)
      {
          System.out.println("Employee name must contain only alphabets.Retype the employee name");
          employeeNames();
      }
      else
      {
    	  setEmployeeName(employeename);
      }
  }
}

