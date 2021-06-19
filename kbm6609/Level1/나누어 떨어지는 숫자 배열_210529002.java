package Divided_ArrayNumbers;

import java.util.*;

public class DividedArrayNumbers_210529002 {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5};
        int divisor = 1;
        int[] answer;

        Arrays.sort(arr);
        Queue<Integer> qe =new LinkedList<>();
        for(int i:arr) if(i%divisor==0) qe.add(i);
        if(qe.size() ==0) answer =new int[]{-1};
        else {
            answer = new int[qe.size()];
            for (int i = 0; i < answer.length; i++) answer[i] = qe.poll();
        }


        for(int i:answer) System.out.print(i+" ");
    }
}
