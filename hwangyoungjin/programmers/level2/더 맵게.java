import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
 
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(long i : scoville){
            pq.add(i);
        }
        
        long min = pq.peek();
        
        int count = 0;
        long n1 = 0;
        long n2 = 0;
        
        while(min < K){
            
            if(pq.size() == 1){
                return -1;
            }
            
            count++;
            n1 = pq.poll();
            n2 = pq.poll();
            
            pq.add((n1+(n2*2)));
            
            min = pq.peek();
            
        }

        return count;
    }
}