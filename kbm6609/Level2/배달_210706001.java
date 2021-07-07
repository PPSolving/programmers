package Delivery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class Delivery_210706001 {
    public static void main(String[] args) {
        int N = 6;
        int[][] road ={{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K = 4;
        int answer= 0;
        
        boolean[] check =new boolean[N];
        Vector<HashMap<Integer,Integer>> rlen =new Vector<>();
        HashMap<Integer, Integer> minlen =new HashMap<>();
        for(int i=0;i<N;i++){
            rlen.add(new HashMap<>());
        }
        for (int i = 0; i < road.length; i++) {
            if(!rlen.get(road[i][0]-1).containsKey(road[i][1]-1)||rlen.get(road[i][0]-1).get(road[i][1]-1)>road[i][2]) {
                rlen.get(road[i][0] - 1).put(road[i][1] - 1, road[i][2]);
                rlen.get(road[i][1] - 1).put(road[i][0] - 1, road[i][2]);
            }
        }
        run(rlen, 0, 0,check,minlen);
        for(int i : minlen.keySet()){
            System.out.println(i+" "+minlen.get(i));
            if(minlen.get(i)<=K)answer++;
        }
        System.out.println(answer);

    }
    static void run( Vector<HashMap<Integer,Integer>> rlen,int in,int sum,boolean[] check,HashMap<Integer, Integer> minlen){
        if(check[in])
        return;
        if(minlen.containsKey(in)&&sum>=minlen.get(in)){
            return;
        }else{
            minlen.put(in,sum);
        }
        check[in] =true;
        Integer[] tmp ;
        HashMap<Integer,Integer> rem =new HashMap<>();
        for(int i:rlen.get(in).values().toArray(new Integer[0])) rem.put(i,1);
        tmp =rem.keySet().toArray(new Integer[0]);
        Arrays.sort(tmp);

        for(int j:tmp){
            for (int i : rlen.get(in).keySet()) {
                if(rlen.get(in).get(i)==j)
                      run(rlen, i, sum + rlen.get(in).get(i), check, minlen);
            }
        }
        check[in] =false;
    }
}
