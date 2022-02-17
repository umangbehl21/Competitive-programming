package Strings;

import java.util.HashMap;

public class checkpermutation {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i)))
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);  //storing key and value in character,Integer HashMap if key is already present we have to increment the count by 1
            else {
                map.put(a.charAt(i), 1);   //if key is found first time its frequency will be 0
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                int freq = map.get(b.charAt(i));
                freq--;
                if (freq == 0) {
                    map.remove(b.charAt(i)); //if frequency become 0 remove that key
                } else {
                    map.put(b.charAt(i), freq); //else put the updated new decremented frequency 
                }
            } else {
                return false;  //if the key is not present in the HashMap but present in the B string then return false because it is that character which is not present in the first String
            }
        }
        if (map.isEmpty()) {
            return true;    //if map is empty in the end means that all the keys matched its corresponding frquency and is removed after being 0
        }
        return false; //if map is not empty it means that some extra character was there in the map which is not in the second string so return false
    }

    public static void main(String[] args) {
        boolean ok = isAnagram("fggfg", "gfg");
        System.out.println(ok);
    }

}
