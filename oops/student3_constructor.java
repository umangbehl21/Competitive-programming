package oops;

public class student3_constructor {     //every class have a default constructor used for making objects if we make our own constructor then default one does'nt exist or will be lost
    String name;
    int rollno;
    public student3_constructor(String n)   //we can have multiple constructor and based on these constructors we can create objects with different properties
    {
        name = n;
    }
    public student3_constructor(String n,int rn) //now we have two constructor we can make its object using any of constructor based on which property we want in our object
    {
         rollno = rn;
         name = n;
    }
    public void print()
    {
        System.out.println("name :"+ name);
        System.out.println("rollno :" +rollno);
    }
}
