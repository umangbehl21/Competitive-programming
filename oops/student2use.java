package oops;

public class student2use {
    public static void main(String[] args) {
        student2 s2 = new student2();
        s2.name = "mikasa ackerman";
        s2.setrollno(-20);    //we cannot set roll no to minus as per the class setter method 
        System.out.println(s2.getrollno());   //so we will get 0 as output 
    }
}
