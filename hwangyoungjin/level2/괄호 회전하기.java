import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuffer buf = new StringBuffer(s);
        for(int i=0; i<s.length(); i++){
            boolean result = check(buf);
            if(result){
                answer++;
            }
            char ch = buf.charAt(0);
            buf.delete(0,1);
            buf.append(ch);
            
        }
        return answer;
    }
    public static boolean check(StringBuffer buf){
        Stack<Character> list = new Stack<>();
        //init
        char chek = buf.charAt(0);
        if(chek == ']' || chek == '}' || chek == ')') return false;
        list.push(chek);
        int idx = 1;
        while(idx < buf.length()){
            char ch = buf.charAt(idx++);
            
            //Stack에서 하나 뽑아서
            switch(ch){
                case ']':
                    if(list.isEmpty()) return false; 
                    if(list.peek() == '[') list.pop();   
                    else list.push(ch);
                    break;
                case '}':
                    if(list.isEmpty()) return false; 
                    if(list.peek() == '{') list.pop();                       
                    else list.push(ch);
                    break;
                case ')':
                    if(list.isEmpty()) return false; 
                    if(list.peek() == '(') list.pop();   
                    else list.push(ch);
                    break;
                default:
                    list.push(ch);
                    break;
            }
        }
    
        return list.isEmpty();
    }
}