import java.util.*;
class Solution {
    public String solution(String p) {

        String answer = check(p);
        
        return answer;
    }
    
    //주어진 p를 균형잡힌 괄호 문자열 u,v로 분리 후
    //
    public static String check(String p){
        
        StringBuffer result = new StringBuffer();
        
        if(p.equals("")){
            return "";
        }
        
        String u = "";
        String v = "";
        StringBuffer buf = new StringBuffer();
        boolean able = false; // 올바른지 확인
        int left = 0; // 왼쪽 괄호
        int right = 0; // 오른쪽 괄호
        
        Stack<Character> line = new Stack<>(); 
        //p를 하나씩 검사하면서 균형 잡히면 바로 break;
        for(int i=0; i<p.length(); i++){
            char ch = p.charAt(i);
            buf.append(ch); 
            switch(ch){
                case '(':
                    line.push(ch);
                    left ++;
                    break;
                case ')':
                    
                    if(!line.empty() && line.peek() == '('){
                        
                        line.pop();
                        
                        able = line.size() == 0 ? true : false;
                        
                    } else{
                        line.push(ch);
                    }
                    right++;
                    break;
            }
            if(right == left){
                u = buf.toString();
                v = p.substring(i+1);
                break;
            }
        }
        
        
        if(able){
            //u는 올바른 괄호문자열이므로 저장 후 
            result.append(u);
            //v에 대해 다시 재귀
            result.append(check(v));
            return result.toString();
            
        } else{
            //u는 올바른 괄호가 아니므로
            StringBuffer newBuf = new StringBuffer();
            newBuf.append('(');
            newBuf.append(check(v));
            newBuf.append(')');
            
            StringBuffer ustr = new StringBuffer();
            for(int i=1; i<u.length()-1; i++){
                if(u.charAt(i) == '(') ustr.append(")");
                else ustr.append("(");
            }
        
            newBuf.append(ustr.toString());
            return newBuf.toString();
        }
        
    }
}