package hardlevel;


public class warmreceptionpro {
    static int max = Integer.MIN_VALUE;  //global static variable max have class to every static function in clas
    public static void warmreception(int tracker[],int from,int to)
    {
        for(int i = from;i<=to;i++)   //900 to 1100 for first iteration,1000 to 1300 for second,1100 to 1130 for third iteration 
        {
            if(tracker[i] + 1 > max)  
            {
                max = tracker[i] + 1;
            }
            tracker[i] = tracker[i] + 1;
        }
    } 
    public static int timetracker(int arrival[],int departure[])
    {
        int tracker[] = new int[2360];
        for(int i = 0;i<arrival.length;i++)
        {
           warmreception(tracker,arrival[i],departure[i]);
        }
        return max;
    }
   public static void main(String[] args) {
       int arrival[] = {900,1000,1100,1030,1600};
       int departure[] = {1900,1300,1130,1130,1800};
       System.out.println(timetracker(arrival, departure));
   } 
}
