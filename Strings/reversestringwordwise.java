package Strings;

public class reversestringwordwise {
    public static String reverseWords(String s) {
        String str = "";
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;
            if (i < 0)
                break;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (str.isEmpty()) {
                str = str.concat(s.substring(i + 1, j + 1));
            } else {
                str = str.concat(" " + s.substring(i + 1, j + 1));
            }
        }
        return str;
    }

    public static void main(String[] args) {
        {
            String str = "     by the order of the peaky blinders      ";
            System.out.println(reverseWords(str));
        }
    }
}
