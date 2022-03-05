package recursion;

public class reverseastringrecursively {
    private static String reverse(String s)
    {
        if(s.length() == 0)
        {
            return s;
        }
        String smallans = reverse(s.substring(1));
        return smallans +s.charAt(0);

    }
    public static void main(String[] args) {
        System.out.println(reverse("tajmahal is beautiful"));
    }
}