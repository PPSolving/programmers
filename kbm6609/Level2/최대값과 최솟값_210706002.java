package Max_And_Min;

import java.util.Arrays;

public class MaxAndMin_210706002 {
    public static void main(String[] args) {
        String s="-1 -2 -3 -4";
        String[] tmp =s.split(" ");
        int[] arr= new int[tmp.length];
        for (int i=0;i<arr.length;i++) {
            arr[i] =Integer.valueOf(tmp[i]);
        }
        Arrays.sort(arr);
        String answer = String.valueOf(arr[0])+" "+String.valueOf(arr[arr.length-1]);
        System.out.println(answer);
    }
}
