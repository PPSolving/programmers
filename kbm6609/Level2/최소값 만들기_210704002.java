package Create_Min_Value;

import java.util.Arrays;

public class CreateMinValue_210704002 {
    public static void main(String[] args){
        int[] A ={1,2};
        int[] B ={3,4};
        int answer =0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            answer +=  A[i] *B[B.length-1-i];
        }
        System.out.println(answer);

    }
}
