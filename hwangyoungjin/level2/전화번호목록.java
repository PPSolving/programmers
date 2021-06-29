import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        boolean answer = true;
        StringBuffer buf = new StringBuffer();
       
        //정렬을 통해 자신이 바로 뒤의 접두어가 아니면 continue;
        for(int i=0; i<phone_book.length-1; i++){
            buf.delete(0,buf.length());
            buf.append(phone_book[i+1]);
                
            if(buf.toString().contains(phone_book[i])
               && buf.indexOf(phone_book[i]) == 0){
                return false;
            }
            
        }
        return answer;
    }
}