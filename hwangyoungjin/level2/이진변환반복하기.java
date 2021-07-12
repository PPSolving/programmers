import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int count = 0;
        int removeNum = 0;
        StringBuffer buf = new StringBuffer();
        Stack<Integer> stack = new Stack<>();   
                
        while(!s.equals("1")){
            stack.clear();
            buf.delete(0,buf.length());
            count++;
            int originLen = s.length();
            int num = originLen;
            if(s.contains("0")){
                String newStr = s.replaceAll("0","");
                num = newStr.length();
            }
            removeNum += originLen - num;

            while(num > 1){
                int rest = num%2 == 0 ? 0 : 1;
                stack.add(rest);
                num /= 2;
            }
            stack.add(1);
            while(!stack.isEmpty()){
                buf.append(stack.pop());
            }
            s = buf.toString();
        
        }
        
        answer = new int[]{count,removeNum};
        return answer;
    }
}