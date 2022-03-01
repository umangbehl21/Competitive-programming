package oops.polymorphism;

public class vehicle {
    String color;
    int speed;

}
class vehicleuse
{
    public static void main(String[] args) {
        vehicle v = new car(); //vehicle acting as a car
        vehicle v1 = new truck(); //vehicle acting as a truck thus vehicle can take manyforms this is polymorphism because truck class and car class is child of vehicle it can point to any of its child
        //v.isconvertible //we cannot acess a particular datamember of subclass of vehicle because on compile time checking v is of vehicle type so it will give error if we will try to access that data member not present in vehicle class
        v1.color = "black"; //we can access color and speed only because it is present in the vehicle and v is pointing to vehicle type 
        v.color = "blue";
    }
}
