class Solution {
    public String solution(String s) {
        int num = (int)(s.length()%2);
        int quo = (int)(s.length()/2);
        String answer = "";
        if(num == 0){ //짝수 길이
            answer = String.valueOf(s.charAt(quo-1))+String.valueOf(s.charAt(quo));            
        } else{ //홀수 길이
            answer = String.valueOf(s.charAt(quo));
        }
        
        return answer;
    }
}