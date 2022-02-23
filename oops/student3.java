package oops;

public class student3 {
    private final int rollnumber;  // we can initialise a final datamember either here during declaration
    String name; 
    static int numstudents; //static datamembers belongs to class they cannot be reinitialise they are incremented when the object is created and its value can be accessed by classname too because every object shares the same value
    public student3(int rollnumber,String name)
    {
       System.out.println(this); //now we will see this have the same adress as object
       this.rollnumber = rollnumber; //or if we dont initialise during its declaration now java knows that a final data member can only be initialised in constructor because it points to single object with single copy so we will never be able to reinitialise a final data member again and again because we cannot point to existing object again and again 
       this.name = name; //this keyword is used to pass thr value of local parameters to the global data members
       numstudents++; //every time the constructor will be called during object creation numstudents will get incremented and it is static every object will be able to tell the total students
    }
    public int getrollnumber() //since our rollnumber is private it can be accessible to other classes through getfunction
    {
        return rollnumber;
    }
    public void print()
    {
        System.out.println("name :"+name);
        // System.out.println("numstudents :"+numstudents);
        System.out.println("rollnumber :"+rollnumber);
        
    }

}
class student3use
{
   public static void main(String[] args) {
       student3 s3 = new student3(218,"eren yeager");
       System.out.println(s3); // compare the address of this and s3 it will be same
       s3.print();
       student3 s4 = new student3(131,"devan");
       s4.print();
       student3 s5 = new student3(187,"ritik");
       s5.print();
       System.out.println("numstudents :"+student3.numstudents); //because num students are static we can access it through classname it will be best

   }
   
}