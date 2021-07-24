import java.util.Optional;

class Solution {
    public int solution(String s) {

        int answer = 0;
        
        if(s.charAt(0) == '-'){
            String numStr = Optional.ofNullable(s)
                .filter(str -> str.length() > 0)
                .map(str-> str.substring(1)).get();
            answer = -1*Integer.parseInt(numStr);
        } else{
            answer = Integer.parseInt(s);
        }
        
        return answer;
    }
}