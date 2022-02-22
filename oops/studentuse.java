package oops;

public class studentuse {
    public static void main(String[] args) {
        student s1 = new student();  
        s1.rollno = 36;
        s1.name = "eren yeager";
        System.out.println(s1);  //s1 will store the adress or reference of the student class which is the blueprint for out object
        System.out.println(s1.name);
        System.out.println(s1.rollno);
        student s2 = new student(); //we can make as many objects as we want if we have its blueprint also known as class
        s2.name = "levi";
        s2.rollno = 18;
        System.out.println(s2.name);
        System.out.println(s2.rollno);
    }

}
