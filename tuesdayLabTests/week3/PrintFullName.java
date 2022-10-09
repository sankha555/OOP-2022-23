import java.util.Scanner;

class Person {
    private String firstName;
    private String lastName;
    
    /* Write getter function called `getFirstName()` */
    String getFirstName(){
        return firstName;
    }
    
    /* Write setter function called `setFirstName()` */
    void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    /* Write getter function called `getLastName()` */
    String getLastName(){
        return lastName;
    }
    
    /* Write setter function called `setLastName()` */
    void setLastName(String lastName){
        this.lastName = lastName;
    }
}

public class Solution{
    public static void main(String[] args) {
        Person person = new Person();
        
        /* Take inputs and use the object 'person' appropriately to print the answer */
        Scanner sc = new Scanner(System.in);
        String f = sc.nextLine();
        String l = sc.nextLine();
        
        person.setFirstName(f);
        person.setLastName(l);
        System.out.println(person.getFirstName() + " " + person.getLastName());
    }
}
