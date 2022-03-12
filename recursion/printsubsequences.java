package recursion;

public class printsubsequences {
    public static void print(String str,String outputsofar)
    {
        if(str.length() == 0)
        {
            System.out.println(outputsofar);
            return;
        }
        print(str.substring(1), outputsofar); //disclude one time
        print(str.substring(1), outputsofar + str.charAt(0)); //include second time 
    }
    public static void main(String[] args) {
        print("xyz","");
    }
}
