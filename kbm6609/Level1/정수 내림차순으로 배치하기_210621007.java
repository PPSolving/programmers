package Integer_Descending_Order;

import java.util.HashMap;

public class IntegerDescendingOrder_210621007 {
    public static void main(String[] args) {

        long n=118372;
        HashMap<Integer, Integer> hm=new HashMap<>();
        while(n>0){
            hm.put((int)(n%10),hm.getOrDefault((int)(n%10),0)+1);
            n/=10;
        }

            System.out.println(hm.getOrDefault(1,0));

        long answer =0;
        for(int i=9;i>=0;i--){
            for(int j=0;j<hm.getOrDefault(i,0);j++){
                answer*=10;
                answer += i;
            }
        }
        System.out.println(answer);

    }
}
