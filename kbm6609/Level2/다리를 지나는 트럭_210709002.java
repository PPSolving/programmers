package Truck_Passing_Bridge;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingBridge_210709002 {
    public static void main(String[] args) {
        int bridge_length=100;
        int weight=100;
        int[] truck_weights={10,10,10,10,10,10,10,10,10,10};
        Queue<Integer[]> qu = new LinkedList<>();
        int sum=0;
        int i=0;
        int sec=0;
        while(i< truck_weights.length ||!qu.isEmpty()){
            sec++;
            if(!qu.isEmpty()&&sec-qu.peek()[1]>=bridge_length) {
                sum-=qu.poll()[0];
            }
            if(i< truck_weights.length&&sum+truck_weights[i]<=weight) {
                qu.add(new Integer[]{truck_weights[i],sec});
                sum += truck_weights[i];
                i++;
            }
        }
        System.out.println(sec);
    }
}
