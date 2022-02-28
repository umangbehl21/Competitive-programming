package oops.inheritance;

public class car extends vehicle {
    boolean isconvertible;
    int noofgears;
    public car(int noofgears,int maxspeed) //when we will make the object of car class constructor will be used and firstly object of parent(vehicle) class will be made then it will make its own object and if parent class constructor have parameter then we have to initialise that parameter also using super keyword
    {
        super(maxspeed); //this maxpeed is parameter of parent class constructor as we know when child class make its own object firstly parent class object is made also 
        this.noofgears = noofgears;
        System.out.println("car constructor");
    }
    public void print()
    {
        System.out.println("no of gears : "+noofgears);
        System.out.println("color is : "+color);
        System.out.println("conversion"+isconvertible);
        System.out.println("max speed :"+getMaxspeed());
    }

    public static void main(String[] args) {
        car c = new car(5,100);//now we have made constructor we have to assign the value to parent argumented constructor as well as our own argument constructor//on making the object of class car we will see that it have the function and properties of car class as well as vehicle class car because it extends vehicle class
        c.setmaxspeed(100); //car class can not directly inherit the data member maxspeed but can inherit it using setmaxspeed and getmaxspeed
        c.color = "blue"; //color property is of vehicle but because car is extending vehicle it can access it
        c.noofgears = 5;
        c.isconvertible = true;
        c.print(); //if parent class and the child class have the function of same name child class will consider its own function in this case 
        
    }
}
