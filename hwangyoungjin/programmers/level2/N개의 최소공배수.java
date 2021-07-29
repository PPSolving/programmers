import java.util.*;
class Solution {
    public int solution(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
        }
        
        while(pq.size() > 1 ){
            int first = pq.poll();
            int second = pq.poll();
            int gd = gcd(first,second);
            int lcm = first*((second)/gcd(first,second));
            pq.add(lcm);
        }
        
        return pq.poll();
    }
    public static int gcd(int a, int b){
        if(a<b){
            int tmp = a;
            a = b ;
            b = tmp;
        }
        // a > b
        int r1 = a;
        int r2 = b;
        while(r2 != 0){
            int remain = r1%r2;
            r1 = r2;
            r2 = remain;
        }
        return r1;
        
    }
}