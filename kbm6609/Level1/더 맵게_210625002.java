package Spicier;

import java.util.PriorityQueue;

public class Spicier_210625002 {
    public static void main(String[] args) {
        int[] scoville={1, 2, 3, 9, 10, 12};
        int K=7;

        int answer=0;
        int a,b;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            if(scoville[i] <=K) pq.add(scoville[i]);
        }
        while(pq.peek()<K){
            if(pq.size()<2) {
                if(pq.peek()<K) answer=-1;
                break;
            }
            pq.add(pq.poll()+pq.poll()*2);
            answer++;
        }
        System.out.println(answer);
    }
}
