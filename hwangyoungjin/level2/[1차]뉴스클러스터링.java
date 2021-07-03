import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        Map<String,Integer> totalMap = new HashMap<>();
        
        String s1 = str1.toLowerCase();
        for(int i=0; i<s1.length()-1; i++){
            String str = s1.substring(i,i+2);
            if( str.charAt(0) < 'A' 
               || (str.charAt(0) > 'Z' && str.charAt(0) < 'a') 
               || str.charAt(0) > 'z'
               || str.charAt(1) < 'A' 
               || (str.charAt(1) > 'Z' && str.charAt(1) < 'a' )
               || str.charAt(1) > 'z'){
                continue;
            }
            map1.put(str,map1.getOrDefault(str,0)+1);
            totalMap.put(str,totalMap.getOrDefault(str,0)+1);
        }
        
        String s2 = str2.toLowerCase();
        for(int i=0; i<s2.length()-1; i++){
            String str = s2.substring(i,i+2); 
            if( str.charAt(0) < 'A' 
               || (str.charAt(0) > 'Z' && str.charAt(0) < 'a') 
               || str.charAt(0) > 'z'
               || str.charAt(1) < 'A' 
               || (str.charAt(1) > 'Z' && str.charAt(1) < 'a' )
               || str.charAt(1) > 'z'){
                continue;
            }
            
            map2.put(str,map2.getOrDefault(str,0)+1);
            totalMap.put(str,totalMap.getOrDefault(str,0)+1);
            
        }
        
        //모두 공집합
        if(map1.size() == 0 && map2.size() == 0 ){
            return 65536;
        }
        
        double count = 0;
        int total = 0;
        for(String key : totalMap.keySet()){
            
            //해당 key를 2개 map이 모두 포함하고 있으면
            if(map1.containsKey(key) && map2.containsKey(key) ){
                int num1 = map1.get(key);
                int num2 = map2.get(key);
                if( num1 < num2){
                    count += num1; //작은 값이 교집합 개수
                    total += num2;
                } else{
                    count += num2; 
                    total += num1;
                }
            } else{
                total += totalMap.get(key);
            }
        }
        
        double d = count/total;
        int answer = (int) (d*65536);
        return answer;
    }
}