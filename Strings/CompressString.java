package Strings;

public class CompressString {
    public static String getCompressedString(String str) {
        String s = str.substring(0, 1); // or we can write str.charAt(i)+""; we have to add that empty string so that we can store it in string
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char prev = str.charAt(i - 1);
            char curr = str.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                if (count > 1) {
                    s += count; 
                    count = 1;
                }
                s += curr;
            }
        }
        if (count > 1) {
            s += count;
            count = 1;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(getCompressedString("aabbcc"));
    }
}
