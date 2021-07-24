import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            switch(ch){
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty()) return false;
                    if(stack.pop() == ')') return false;
                    break;
            }
        }
        if(!stack.isEmpty()) return false;
        

        return answer;
    }
}