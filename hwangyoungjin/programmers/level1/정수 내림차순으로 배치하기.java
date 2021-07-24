import java.util.*;

class Solution {
    public long solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(n>0){
            int num = (int)(n%10);
            n = n/10;
            list.add(num);
        }
        
        Collections.sort(list,new Comparator<Integer>(){
           @Override
            public int compare(Integer s1,Integer s2){
                return (s1-s2)*(-1);
            }
        });
        
        long mul = (long)(Math.pow(10,list.size()));
        
        long answer = 0;
        
        for(int i=0; i<list.size(); i++){
            mul = mul/10;
            answer += (list.get(i) * mul);
        }
        
        
        return answer;
    }
}