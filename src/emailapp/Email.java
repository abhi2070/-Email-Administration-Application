package emailapp;
import java.util.Scanner;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultpasswordLength;
    private String alternateEmail;
    private String companysuffix = "company.com";
    private int mailboxCapacity=500;
    
    // constructor to receive the first name and last name
    public Email(String firstName, String lastName){
            this.firstName=firstName;
            this.lastName=lastName;
           // System.out.println("Email created: "+this.firstName+" "+this.lastName);
            
        //call a method asking for the department-return the department
        this.department=setDepartment();
        //System.out.println("Department: "+this.department);
        
        //call a method that returns a random password
        this.password=randomPassword(8);
        //System.out.println("Your password is: "+this.password);
        
        //combine element to generate email
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companysuffix;
        //System.out.println("Your email is: "+email);
    }
    //ask for the department
    private String setDepartment(){
        System.out.println("New worker: "+firstName+". Department Code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner sc = new Scanner(System.in);
        int depChoice=sc.nextInt();
        if (depChoice==1) {
            return "sales";
        }else if (depChoice==2) {
            return "Dev";
        }else if (depChoice==3) {
            return "Acct";
        }else{
        return "";
        }
    }
    
    //generate a random password
    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()<>";
        char[] password=new char[length];
        for (int i=0; i<length; i++) {
            int rand =(int) (Math.random()* passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
    this.mailboxCapacity=capacity;
    }
    
    //set the alternate email
    public void setAlternateEmail(String altEmail){
    this.alternateEmail=altEmail;
    }
    //change the password
    public void changePassword(String password){
    this.password=password;
    }
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String showInfo(){
        return "Display Name: "+firstName+" "+lastName+
                "\nCompany Email: "+email+
                "\nMailBox Capacity: " +mailboxCapacity+ "MB";
    }
}
