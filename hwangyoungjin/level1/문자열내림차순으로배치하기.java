import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split("");
        
        Arrays.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (-1)*s1.compareTo(s2);
            }
        });
        
        answer = String.join("",strArr);
        
        return answer;
    }
}