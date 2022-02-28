package oops.inheritance;

public class vehicle {
    private int maxspeed; //we can only access private data members using getters and setters
    String color;
    protected int weight; //protected data members are accessible within the same package and to all the subclasses of parent class outside the package too
    public vehicle(int maxspeed) 
    {
        this.maxspeed = maxspeed;
    }
    public int getMaxspeed() {
        return maxspeed;
    }
    public void setmaxspeed(int maxspeed)
    {
        this.maxspeed = maxspeed;
    }
    public void print()
    {
        System.out.println(color);
        System.out.println(maxspeed);
    }

}
