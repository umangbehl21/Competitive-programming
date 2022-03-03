package recursion;

public class countzeros {
    private static int countzero(int num,int count)
    {
        if(num == 0)
        {
            return count;
        }
        int ifzero = num % 10;
        if(ifzero == 0)
        {
            count++;
        }
        return countzero(num/10, count);
    }
    public static int countzerohelper(int num)
    {
        if(num == 0)
        {
            return 1;
        }
        return countzero(num,0);
    }
    public static void main(String[] args) {
        System.out.println(countzerohelper(1110000));
    }
}
