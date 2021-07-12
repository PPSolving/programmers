package Carpet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Carpet_210711002 {
    public static void main(String[] args) {
        int brown=24;
        int yellow=24;
        Queue<Integer> qu =new LinkedList<>();
        int[] answer =new int[2];
        Stack<int[]> st =new Stack<>();
        for(int i=1;i<=yellow;i++){
            if(yellow%i ==0) qu.add(i);
        }
        int[] arr= new int[qu.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =qu.poll();
        }
        for(int i=0;i<(arr.length+1)/2;i++){
            int c= arr[i];
            int r= arr[arr.length-1-i];
            while(c*r<brown+yellow){
                c +=2;
                r +=2;
            }
            if(c*r ==brown+yellow) {
                answer[0] = r;
                answer[1] = c;
                break;
            }
        }
        System.out.println(answer[0] +" "+answer[1]);
    }
}
