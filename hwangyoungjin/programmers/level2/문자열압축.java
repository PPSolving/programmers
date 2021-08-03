import java.util.*;
class Solution {
    public int solution(String s) {
        int len = s.length();
        int min = len;
        //interval = 1,2,3,4, ... len/2
        for(int interval = 1; interval<=len/2; interval++){
            int num = check(interval,s,len);
            if(min > num) min = num;
        } 
        return min;
    }
    public static int check(int interval, String s,int len){
        StringBuffer result = new StringBuffer(); 
        String origin = s.substring(0,0+interval);
        int i = interval;
        int count = 1;
        while((i+interval)<=len){
            String next = s.substring(i,i+interval);
            if(origin.equals(next)){
                count++; 
            } else{
                if(count != 1) result.append(count+"");
                result.append(origin);
                origin = next;
                count = 1;
            }
            i+=interval;
        }
        
        //마지막 문자
        if(count != 1) result.append(count+"");
        result.append(origin);
        
        //interval 이하 남는 문자 있는경우
        if(i < len) result.append(s.substring(i,len));
        
        return result.length();
    }
}