package Camouflage;

import java.util.HashMap;

public class Camouflage_210720002 {
    public static void main(String[] args) {
        String[][] clothes={{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        HashMap<String,Integer> st =new HashMap<>();
        for(int i=0;i<clothes.length;i++) st.put(clothes[i][1], st.getOrDefault(clothes[i][1],0)+1);
        int answer =1;
        for(String s:st.keySet()) answer*=st.get(s)+1;
        answer--;
        System.out.println(answer);

    }
}
