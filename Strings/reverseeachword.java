package Strings;

public class reverseeachword {
    public static String reverseWords(String s) {
        char ch[] = s.toCharArray();
        int i = 0;
        int j = 0;
        while (i <= ch.length) {
            if (i == ch.length || ch[i] == ' ') {
                reverse(ch, j, i - 1);
                j = i + 1;
            }
            i++;
        }
        return new String(ch);
    }

    public static void reverse(char ch[], int j, int i) {
        while (j < i) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("i will keep moving forward"));
    }
}
