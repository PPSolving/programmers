import java.util.*;
class Solution {
    public String solution(String number, int k) {
        //뽑아야하는 개수 
        StringBuffer buf = new StringBuffer(number);
        StringBuffer result = new StringBuffer();
        int need = number.length()-k;
        while(result.length() < need ){
            //buf를 앞에서부터 보면서 조건의 맞는
            //max값 가져와서 result에 붙이기
            int max = 0;
            int maxIdx = 0;
            int needCount = need-result.length();
            
            for(int i=0; i<buf.length(); i++){
                
                //뒤에 남은 개수가 needCount이하이면 탐색X
                if(buf.length()-i < needCount) break; 
                //9나오면 뒤는 볼 필요X
                if(buf.charAt(i) == '9'){
                    maxIdx = i;
                    break;
                }
                if( max < buf.charAt(i) - '0'){
                    max = buf.charAt(i) - '0';
                    maxIdx = i;
                }
            }
            result.append(buf.charAt(maxIdx));
            buf.delete(0,maxIdx+1);
        }
        return result.toString();
    }
}