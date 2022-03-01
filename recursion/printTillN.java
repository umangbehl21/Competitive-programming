package recursion;

public class printTillN {
        static void printTill(int N){
           if(N == 1)
           {
               System.out.print(N+" ");
               return;
           }
           printTill(N-1);
           System.out.print(N+" ");
           //return; //can write return here for clearance that a line is printed then nothing is return to parent function 
        }
        public static void main(String[] args) {
            printTill(509);
        }
    }

