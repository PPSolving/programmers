import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        StringBuffer buf = new StringBuffer();
        
        //대문자 -> 소문자
        String lower = new_id.toLowerCase();
        
        //소문자, 숫자, 0 , _, . 가 아닌것 빼고 ...-> . 으로 변환
        for(int i=0; i<lower.length(); i++){
            if((lower.charAt(i) >= 'a' && lower.charAt(i) <= 'z')
              || (lower.charAt(i) >= '0' && lower.charAt(i) <= '9')
              || (lower.charAt(i) == '_')
              || (lower.charAt(i) == '.')
              || (lower.charAt(i) == '-')){
                buf.append(lower.charAt(i));
            } 
        }
        
        //...-> . 으로 변환
        StringBuffer newBuf = new StringBuffer();
        for(int i=0; i<buf.length(); i++){
            if((buf.charAt(i) >= 'a' && buf.charAt(i) <= 'z')
              || (buf.charAt(i) >= '0' && buf.charAt(i) <= '9')
              || (buf.charAt(i) == '_')
              || (buf.charAt(i) == '-')){
                newBuf.append(buf.charAt(i));
            } else if(buf.charAt(i) == '.'){
                for(int j=i+1; j<buf.length(); j++){
                    if(buf.charAt(j) != '.' || j == buf.length()-1){
                        i = j-1;
                        newBuf.append('.');
                        break;
                    }
                }
            }
        }

        //처음 마지막 '.' 제거
        String newStr = newBuf.toString();
        
        //앞에 제거
        newStr = Optional.ofNullable(newBuf)
            .filter(s -> s.length() != 0 && s.charAt(0) == '.')
            .map(s->s.substring(1,s.length()))
            .orElse(newStr);
        
        //뒤에제거
        newStr = Optional.ofNullable(newStr)
            .filter(s -> s.length() != 0 && s.charAt(s.length()-1) == '.')
            .map(s->s.substring(0,s.length()-1))
            .orElse(newStr);
        
        //빈문자열이면 "a 추가"
        if(newStr.isEmpty()){
            newStr = "a";            
        }
        
        if(newStr.length() > 15){
            newStr = newStr.substring(0,15);
        }
        
        //뒤에 . 있으면 제거
        newStr = Optional.ofNullable(newStr)
            .filter(s -> s.length() != 0 && s.charAt(s.length()-1) == '.')
            .map(s->s.substring(0,s.length()-1))
            .orElse(newStr);

        StringBuffer newAnswer = new StringBuffer(newStr);
        
        if(newStr.length() == 1){
            newAnswer.append(newStr.charAt(0));
            newAnswer.append(newStr.charAt(0));
        } else if(newStr.length() ==2){
            newAnswer.append(newStr.charAt(1));
        }
      
        return newAnswer.toString();
    }
}