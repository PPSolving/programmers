import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String s = clothes[i][1];
            List<String> list;
            if(map.containsKey(s)){
                list = map.get(s);
                list.add(clothes[i][0]);
            } else{
                list = new ArrayList<>();
                list.add(clothes[i][0]);
                map.put(s, list);
            }
        }
        
        
        int[] countNum = new int[map.size()];
        int idx = 0;
        int total = 1;
        
        for(List<String> clos : map.values()){
            total *= (clos.size()+1); //안입는 경우            
        }
        
        return (total-1);
    }
    
}