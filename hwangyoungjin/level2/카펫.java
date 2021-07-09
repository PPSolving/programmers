import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = brown+yellow;
        for(int i=2; i<total/2; i++){
            if(pq.contains(i)) break;
            if(total%i == 0){
                int quot = total/i;
                if(!pq.contains(new Integer(quot))){
                    pq.add(quot);
                } else break;
            }
        }
        
        while(!pq.isEmpty()){
            int quot = pq.poll();
            int firstQuot = total/quot;
            if((quot-2)*(firstQuot-2) == yellow) {
                answer = new int[]{quot,firstQuot};
            }
        }
        
        return answer;
    }
}