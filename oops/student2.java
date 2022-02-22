package oops;

public class student2 {
    private int rollno; //if we don't want other users to change roll no to any integer we can declare field as private and can impose restriction on using setters 
    String name;

    public void setrollno(int rn) {  //the object can only access these non static methods it can't access roll no field without the setters
        if (rn < 0) {                 //here we are restricting if roll no is less than 0 then return
            return;
        }
        rollno = rn; 
    }

    public int getrollno() { 
        return rollno;         
    }
}
