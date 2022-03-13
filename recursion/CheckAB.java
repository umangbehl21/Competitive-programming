package recursion;

public class CheckAB {
    public static boolean check(String s) 
    {
            if(s.length() == 0){
                return true;
            }
            if(s.charAt(0) == 'a'){
              if(s.substring(1).length() > 1 && s.substring(1,3).equals("bb")){  
                  return check(s.substring(3)); //if small part of string is "abb" then call ahead from substring(3)
              }else{
                   return check(s.substring(1)); //if small part is not "abb" and if it is "aa" then control will come in else and call for single "a" will be done and again it will be checked in else and call on empty string will be done and true will be returned
              }
          }
            return false;
        }
    public static void main(String[] args) {  
        System.out.println(check("a")); //each string or substring starts with a and a can be followed by nothing or "bb" or 'a' and each bb is followed by a or nothing
        System.out.println(check("ab")); //false
        System.out.println(check("abbab")); //false at the end b is alone
        System.out.println(check("abbbba")); //false the substring(3)do not start with a
    }
}
