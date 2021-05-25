package Failure_rate;

import java.util.Arrays;
import java.util.HashMap;

public class FailureRate_210524002 {
    public static void main(String[] args) {
        int N=3;
        int[] stages={1,1,2};

        int sum=0;
        int[] answer = new int[N];
        double[] rate =new double[N];
        HashMap<Integer,Double> hm = new HashMap<>();
        int usernum =stages.length;
        for(int i=0;i<usernum;i++) {
            if(stages[i]<N+1) //6은 필요없음
                hm.put(stages[i],hm.getOrDefault(stages[i],0.0)+1);
        }



        for(int i =0;i<N;i++) {
            double tmp =hm.getOrDefault(i+1,0.0);
            if(usernum -sum <=0) rate[i] = 0;
            else rate[i] =tmp/(usernum-sum);
            hm.put(i+1,rate[i]);
            sum +=tmp;
        }
        for(double i:rate) System.out.println(i);
        Arrays.sort(rate);
        int in=0;
        for(int i=N-1;i>=0;i--){
            for(int j =0;j<N;j++){
                if(rate[i] == hm.get(j+1)) {
                    answer[N-1-i]=j+1;
                    if(i>0 && rate[i] ==rate[i-1]) i--;
                    else break;
                }

            }
        }
        for(int i:answer) System.out.println(i);
    }
}
