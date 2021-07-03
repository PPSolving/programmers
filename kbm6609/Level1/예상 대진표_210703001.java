package Estimated_Matchlist;

import java.util.LinkedList;
import java.util.Queue;

public class EstimatedMatchlist_210703001 {
    public static void main (String[] args){
        int n=8;
        int a=4;
        int b =7;
        int answer=0;
        Queue<Integer> qu =new LinkedList<>();
        for(int i=1;i<=n;i++) qu.add(i);
        boolean flag =true;
        while(flag){
            answer ++;
            for(int j=qu.size()/2;j>0;j--) {
                int q1 = qu.poll();
                System.out.print("q1 = " + q1 +" ");
                int q2 = qu.poll();
                System.out.println("q2 = " + q2);
                if ((q1 == a && q2 == b) || (q1 == b && q2 == a)) {
                    flag =false;
                    break;
                }
                if (q1 == a || q1 == b) qu.add(q1);
                else qu.add(q2);
            }
        }
        System.out.println(answer);


    }
}
