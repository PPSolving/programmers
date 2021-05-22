package Lotto_top_and_bottom;

import java.util.HashMap;

public class Lottotopandbottom_210522002 {
    public static void main(String[] args) {
        int[] lottos={0, 0, 0, 0, 0, 0};
        int[] win_nums={38, 19, 20, 40, 15, 25};
        HashMap<Integer,Integer> hm =new HashMap<>();
        int c=0;
        int[] answer =new int[2];
        for(int i:lottos) hm.put(i, hm.getOrDefault(i,0)+1);
        for(int i:win_nums) if(hm.containsKey(i)) c++;
        answer[1] = c >= 2 ? 7-c : 6;
        answer[0] = c + hm.getOrDefault(0,0) >= 2 ? 7-c-hm.getOrDefault(0,0):6;
        System.out.println(answer[0] +"  "+ answer[1]);
    }

}
