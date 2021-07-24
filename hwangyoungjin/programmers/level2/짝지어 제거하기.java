import java.util.*;

class Solution{
    
    public int solution(String s){
        //홀수이면 불가능
        if(s.length()%2 != 0) return 0;
        
        String[] strArr = s.split("");
        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<strArr.length; i++){
            if(stack.isEmpty()) {
                stack.add(strArr[i]);
                continue;
            }
            
            if(stack.peek().equals(strArr[i])) stack.pop();
            else {
                stack.add(strArr[i]);
                //남은 stack 수가 남은 길이보다 크면 종료
                if(stack.size() > strArr.length-i-1) break;
            }
        }
        
        int answer = stack.isEmpty() ? 1 : 0;
       
        return answer;
    }
    
}