import java.util.*;
class Solution {
    public String solution(String s) {
        ArrayList<String> strArr = new ArrayList<>();
        StringBuffer strBuf = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(i == s.length()-1 && s.charAt(i) == ' '){
                strBuf.append(" ");
                break;
            }
            if(s.charAt(i) == ' ' && strBuf.length() != 0){
                while(i+1 != s.length() && s.charAt(i+1) == ' '){
                    strBuf.append(" ");
                    i++;
                }
                strArr.add(strBuf.toString());
                strBuf.delete(0,strBuf.length());
            } else{
                strBuf.append(s.charAt(i));            
            }
        }
        if(strBuf.length() != 0){
            strArr.add(strBuf.toString());
        }
        
        StringBuffer buf = new StringBuffer();
        for(String ss : strArr){
            int len = ss.length();
            char ch = ss.charAt(0);
            if(ch >= 'a' && ch<='z'){
                char rech = (char)((int)ch-(int)('a'-'A'));
                buf.append(rech);
            }else buf.append(ch);
            if(len > 1){
                buf.append(ss.substring(1,len).toLowerCase());
            }
            buf.append(" ");
        }
        buf.delete(buf.length()-1,buf.length());
        return buf.toString();
    }
}