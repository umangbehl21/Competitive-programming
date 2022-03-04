package recursion;

public class sumofdigitsrecursive {
    private static int sum(int num,int oursum)
    {
        if(num > 0)
        {
        oursum += num % 10;
        return sum(num/10,oursum);
        }
        if(num < 0) //number will never be less than zero unless user himself entered -1 or negative number it will always be greater than or equal to 0
        {
            return num;
        }
        return oursum; //else if number become equal to zero return sum till now 
    }
    public static int sum(int num)
    {
        return sum(num, 0);
    }
    public static void main(String[] args) {
        System.out.println(sum(12345));
    }
}
