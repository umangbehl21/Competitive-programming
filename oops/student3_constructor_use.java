package oops;

public class student3_constructor_use {
    public static void main(String[] args) {
        student3_constructor s3 = new student3_constructor("umang"); //now instead of accesing name field of class through s3 we can directly pass it as a parameter
        s3.print();
        student3_constructor s4 = new student3_constructor("manan",29); 
        s4.print(); //print is a non static function in the class which can be accessed by the object
    }
}
