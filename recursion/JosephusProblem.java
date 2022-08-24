
package recursion;
public class JosephusProblem
{
   public static int josephusproblem(int n, int k)
   {
       if(n == 1)
       {
         return 0;  //for last person surviving return 0 it will be converted to its orignal form by tbe function it is called 
       }   
       int x = josephusproblem( n - 1, k);
       int y = (x + k) % n;  //to convert it into the orignal number 
       return y;
   }   
   public static void main(String[] args) {
    System.out.println(josephusproblem(5, 3));
   }
 
}
