package Printers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Printers_210701001 {
    public static void main(String[] args) {
        int[] priorities={1, 1, 9, 1, 1, 1};
        int location=0;
        Deque<Integer> dq =new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            dq.addLast(i);
        }
        int r=-1;
        boolean flag;
        int count =0;

        while(r!=location){
            r = dq.pollFirst();
            flag =false;
            for(int i=0;i<priorities.length;i++){
                if(priorities[r]<priorities[i]){
                    flag =true;
                    dq.addLast(r);
                    r=-1;
                    break;
                }
            }
            if(!flag){
                count++;
                priorities[r] = -1;
            }
        }
        System.out.println(count);
    }

}
