
package assigment;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

enum Course
{
    Computing, Accounting,Business
}

public class Assigment {
    
static Scanner input = new Scanner(System.in);
static long idGen = 101014;
static HashMap<Long,Student> students = new HashMap<>();
    
    public static void main(String[] args) { 
        students.put(((long)101010), new HomeStudent("Hulk","Hogan","07515618180","hoganhulk@gmail.com","London",new Date(),-3000,Course.Computing,101010));
        students.put(((long)101011), new InternationalStudent("Marta","Rana","0797946565","martadagny@gmail.com","Glasgow",new Date(),-6000,Course.Accounting,101011));
        students.put(((long)101012), new InternationalStudent("Chris","Smith","078987456125","chrissmith@hotmail.com","New York",new Date(),-500,Course.Business,101012));
        students.put(((long)101013), new HomeStudent("Andrzej","Whiteman","07984215897","an1@gmail.com","New Delhi",new Date(),-5000,Course.Business,101013));
    menu();
       
        }
    
    private static void menu(){
        System.out.println("**********************");
        System.out.println("**Bright Future**");
        System.out.println("**********************");
        System.out.println("1.Enroll");
        System.out.println("2.Pay fee*");
        System.out.println("3.List of student");
        System.out.println("4.Remove Student from the Course");
        System.out.println("5.View Student Profile*");
        System.out.println("6.Change Course");
        System.out.println("7.Managment Raport");
        System.out.println("\t Exit");
        System.out.println("Enter Option:");
        byte option = input.nextByte(); input.nextLine();
        
        switch(option)
                {
                    case 1 :
                    register(courseSe1());
                    break;
                    
                    case 2:
                    payFees();
                    break;
                    
                    case 3:
                        feesPaid();
                    break;
                    
                    case 4:
                        removeStudent();
                    break;
                    
                    case 5 :
                        profile();
                    break;
                    
                    case 6 :
                        changeCourse();
                    break;
                    
                    case 7:
                        mgmRap();
                   
                    break;
                    
                    case 8 :
                        feestobePaid();
                    break;
                    
                    default :
                    System.out.println("Please enter option 1-8");
                    System.out.println("Press any key to continued...");
                    input.nextLine();
                    menu();
                }
        
          menu();
    }
    
    private static Course courseSe1(){
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("**1.Accounting**");
        System.out.println("**2.Computing***");
        System.out.println("**3.Bussness Managment***");
        System.out.println("4.\t Return to Menu");
        byte option = input.nextByte();input.nextLine();
        switch(option)
        {
            case 1:
                return Course.Accounting;
                
            case 2 :
                return Course.Computing;
                
            case 3:
                return Course.Business;
                
            case 4:
                
                defult:
                System.out.println("Please enter option 1-4");
                System.out.println("Please enter any key to continue...");
                input.nextLine();
                courseSe1();
        }
                 
                 return null;
        }
    

        
    private static void register(Course _c){
            System.out.println("************************");
            System.out.println("**Bright Future**");
            System.out.println("************************");
            System.out.println("*First Name**"); 
            String _fn = input.nextLine();
            System.out.println("**Surname**");
            String _sn = input.nextLine();
            System.out.println("**Adress**");
            String _add = input.nextLine();
            System.out.println("**Telephone**");
            String _tel = input.nextLine();
            System.out.println("**Email Adress");
            String _em = input.nextLine();
            Date _dob = getDOB();
            System.out.println("Home Student? Y/N");
            String ans = input.nextLine();
            Student _s;
            
            if(ans.equalsIgnoreCase("Y"))
            {
                _s =new HomeStudent(_fn,_sn,_tel,_em,_add,_dob,-3000,_c,idGen);
            }
            else
            {
                _s = new InternationalStudent(_fn,_sn,_tel,_em,_add,_dob,-6000,_c,idGen);
            }
            students.put(idGen,_s);
            idGen++;
            
         }
    private static Date getDOB(){
        SimpleDateFormat format = new SimpleDateFormat ("dd/mm/yyyy");
        Date _realDob = null;
        System.out.println("Date of Birth (dd/mm/yyyy):");
        String _dob = input.nextLine();
        try
        {
            _realDob = format.parse(_dob);
        }
        catch (ParseException e)
    {
        System.out.println("Unknown Format,use:DD/MM/YYYY");
        getDOB();
    }
            return _realDob;
  }
    private static void profile()
        {
            System.out.println("************************");
            System.out.println("**Bright Future**");
            System.out.println("************************");
            System.out.println("Please enter ID:");
            long id =input.nextLong();input.nextLine();
            System.out.println(students.get(id).getFn());
            System.out.println(students.get(id).getSn());
            System.out.println(students.get(id).getAdd());
            System.out.println(students.get(id).getDob());
            System.out.println(students.get(id).getTel());
            System.out.println(students.get(id).getId());
            System.out.println(students.get(id).getEm());
            System.out.println(students.get(id).getFees());
            
            if(students.get(id) instanceof HomeStudent)
            {
                System.out.println("HomeStudent");
            }
            else
            {
                System.out.println("InternationalStudent");
            }
            
        }
    
    private static void payFees(){
        System.out.println("************************");
            System.out.println("**Bright Future**");
            System.out.println("************************");
            System.out.println("Please enter ID:");
            long id = input.nextLong();input.nextLine();
            System.out.println("Please enter Fees Amount:");
            double _fees= input.nextDouble();input.nextLine();
            if(students.containsKey(id))
            {
                students.get(id).payment(_fees);
            }
            System.out.println(students.get(id).getFn());
            System.out.println(students.get(id).getSn());
            System.out.println(students.get(id).getAdd());
            System.out.println(students.get(id).getDob());
            System.out.println(students.get(id).getTel());
            System.out.println(students.get(id).getId());
            System.out.println(students.get(id).getEm());
            System.out.println(students.get(id).getFees());
            
            if(students.get(id)instanceof HomeStudent)
            {
                System.out.println("Home Student");
            }
            else
            {
                System.out.println("International Student");
            }
    }

    private static void feestobePaid()
    {
            System.out.println("************************");
            System.out.println("**Bright Future**");
            System.out.println("************************");
            System.out.println("Please enter ID:");
            long id = input.nextLong();input.nextLine();
            System.out.println("Please enter Fees Amount");
            double _fees = input.nextDouble();input.nextLine();
            if(students.containsKey(id))
            {
                students.get(id).payment(_fees);
                System.out.println(students.get(id).getFn());
                System.out.println(students.get(id).getSn());
                System.out.println(students.get(id).getId());
                System.out.println("Fees Paid\nPress any key to Continue...");
                input.nextLine();
            }
            else
            {
               System.out.println("No such a student ID");
            }
    }
    private static void removeStudent(){
        System.out.println("Please enter ID:");
             long id =input.nextLong();input.nextLine();
             Course _c =courseSe1();
             if(students.containsKey(id))
             {
            students.get(id).setCourse(_c);
            System.out.println(students.get(id).getFn());
            System.out.println(students.get(id).getSn());
            System.out.println(students.get(id).getId());
            System.out.println("Student removed from the course");
            input.nextLine();
             }
    }
        
    
    
private static void changeCourse(){
             System.out.println("************************");
             System.out.println("**Bright Future**");
             System.out.println("************************");
             System.out.println("Please enter ID:");
             long id =input.nextLong();input.nextLine();
             Course _c =courseSe1();
             if(students.containsKey(id))
             {
            students.get(id).setCourse(_c);
            System.out.println(students.get(id).getFn());
            System.out.println(students.get(id).getSn());
            System.out.println(students.get(id).getId());
            System.out.println("Course Changed to :"+_c.toString()+" \nPress any key");
            input.nextLine();
             }
}
            
        private static void mgmRap(){
            System.out.println("************************");
            System.out.println("**Bright Future**");
            System.out.println("************************");
            System.out.println("1.Fees paid to date");
            System.out.println("2.Fees to be paid");
            System.out.println("3.Most popular Course");
            System.out.println("4.Least popular course");
            System.out.println("Enter option");
            byte option = input.nextByte();input.nextLine();
            
            switch(option)
                    {
                        case 1 :
                            feesPaid();
                        break;
                        
                        case 2:
                            feesToBePaid();
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            defult:
                System.out.println("Please enter option 1-4");
                mgmRap();
                            
            }
        }

           public static void feesPaid()
           {
               Iterator iter = students.values().iterator();
               double total;
               while(iter.hasNext())
               {
                   Student _s = (Student)iter.next();
                   if(_s instanceof HomeStudent)
                   { 
                       total = _s.getFees()+3000;
               }
               else
               {
                       total = _s.getFees()+6000;
               }
            
      }
               
               System.out.println("Paid Fees up to date");
               
           }
public static void feesToBePaid()
               {
               Iterator iter = students.values().iterator();
                   double total = 0;
                   while (iter.hasNext())
                   {
                       Student _s = (Student)iter.next();
                       if(_s instanceof HomeStudent)
                       {
                           System.out.println(total);
                           total -=_s.getFees();
                       }
                       else
                       {
                           System.out.println(total);
                       }
                   }
               }
               
               
               
             
             
             
             
      
    
     
        
    
            


