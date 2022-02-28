package oops.inheritance_protected;

import oops.inheritance.vehicle;

public class truck extends vehicle {
    int maxloadingcapacity;
    public void print()
    {
       super.print();// Where the "super" keyword in Java is used as a reference to the object of the superclass. This implies that to use "super" the method should be invoked by an object, which static methods are not. Therefore, you cannot use the "super" keyword from a static method
       System.out.println(maxloadingcapacity);
    }
    public static void main(String[] args) {
        truck tr = new truck();
        tr.maxloadingcapacity = 500;
        tr.weight = 100; //as we know a subclass can access its parent class data members which is declared protected even outside the package because child is extending parent
        tr.setmaxspeed(70);
        tr.print();
    }
}
