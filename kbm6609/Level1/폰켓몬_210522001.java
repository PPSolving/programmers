package phonkemon;

import java.util.HashMap;

public class phonkemon_210522002 {
    public static void main(String[] args) {
        int[] nums={3,1,2,3};
        HashMap<Integer,Integer> Hm=new HashMap();
        for(int i:nums){
            Hm.put(i,Hm.getOrDefault(i,0)+1);
        }
        int getnum = nums.length/2;
        int kindnum= Hm.size();
        int answer = kindnum-getnum <= 0 ? kindnum : getnum;
        System.out.println(answer);
    }
}
