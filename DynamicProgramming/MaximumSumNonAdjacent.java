package DynamicProgramming;

public class MaximumSumNonAdjacent {
    static int maxloot = Integer.MIN_VALUE;
	public static int maxMoneyLooted(int[] houses) {
	  int inc = houses[0];
      int exc = 0;
      for(int i = 1;i<houses.length;i++)
      {
        int newinc = houses[i] + exc;  //new include is the sum of current element and the previous exclude 
        int newexc = Math.max(inc, exc); //new exclude is the max between the previous include and previous exclude as previous include is not allowed to include again the current level max is taken between exlude and include the greater between one of them will be greater till the end  
        
        inc = newinc; //newinclude will become previous for next level
        exc = newexc; //new exclude will become precious for next level
      }
      return Math.max(inc, exc);
	}
    public static void main(String[] args) {
        int houses[] = {10,2,3,11}; //9583 8878 3709 6449 6541 6394 376 3126 5077 964 
        System.out.println(maxMoneyLooted(houses));
    }
}
