package recursion;

public class returnsubsequences {
    public static String[] subsequences(String s) {
        if (s.length() == 0) {
            String ans[] = { "" };
            return ans;
        }
        String smallans[] = subsequences(s.substring(1));
        String ans[] = new String[smallans.length * 2];
        for (int i = 0; i < smallans.length; i++) {
            ans[i] = smallans[i];
        }
        for(int i = 0;i<smallans.length;i++)
        {
            ans[smallans.length + i] = s.charAt(0) + smallans[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        String s[] = subsequences("xyz");
        for(int i = 0;i<s.length;i++)
        {
            System.out.println(s[i]);
        }
    }
}
