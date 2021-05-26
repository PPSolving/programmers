package Pick_two_and_add;

import java.util.Arrays;
import java.util.HashMap;

public class PickTwoAndAdd_210526002 {
    public static void main(String[] args) {
        int[] numbers ={2,1,3,4,1};

        HashMap<Integer, Integer> hm =new HashMap<>();
        for(int i=0;i < numbers.length;i++){
            for(int j=i+1; j<numbers.length;j++)hm.put(numbers[i]+numbers[j],0);
        }
        int[] answer =new int[hm.size()];
        Integer[] th= hm.keySet().toArray(new Integer[hm.size()]);
        Arrays.sort(th);
        for(int i =0; i<hm.size();i++) answer[i] =th[i];


    }
}
