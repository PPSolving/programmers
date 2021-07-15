import java.util.*;
class Solution {
    public static boolean check = true;
        
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s2.startsWith(s1) || s1.startsWith(s2)){
                    check = false;   
                }
                return s1.compareTo(s2);
            }
        });
        return check;
    }
}