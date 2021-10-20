package employee;

import java.util.*;
import java.util.regex.*;
abstract class employeeMail extends employeeDob{
    static String eMail;
    public static void setEmployeeMailId(String eMails)
    {
    	EmployeeDetails.alist.add(eMails); 
    }
    public static String getEmployeeMail()
    {
        return eMail;
    }
    public static boolean mailIdCheck(String mail_id)
    {
            String emailPattern = "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*";
            Pattern p = Pattern.compile(emailPattern);
            Matcher m = p.matcher(mail_id);
            return m.matches();
    }
        public static void employeeMailIds()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Employee's Mail Id");
            String mail_id= sc.next();
            boolean bool = mailIdCheck(mail_id);
            if(!bool)
            {
                System.out.println("The given mail id is not valid");
                employeeMailIds();
            }
            else
            {
            	setEmployeeMailId(mail_id);
            }
        }
        
    }
    
