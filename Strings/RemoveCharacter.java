package Strings;

public class RemoveCharacter {

    static String removeAllOccurrencesOfChar(String input, char c) {
        int i = 0;
        String str = "";
        while (i < input.length()) {
            if (input.charAt(i) == c) { //if it matches the character 
                i++;                    //first increment it to next character
                continue;               //then skip that current iteration so that we can check the current character we have jumped on if we skip continue then we will be blindly adding that character into our string 
            }
            str += input.charAt(i);
            i++;
        }
        return str;
    }

    public static void main(String args[]) {
        System.out.println(removeAllOccurrencesOfChar("aabccbaa", 'a'));
    }
}
