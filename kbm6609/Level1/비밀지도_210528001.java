package Secret_Map;

import java.util.ArrayList;

public class SecretMap_210528001 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 ={27 ,56, 19, 14, 14, 10};
        int[] result = new int[n];
        for(int i =0; i<n;i++) result[i] = arr1[i]|arr2[i];
        String[] answer= new String[n];
        for(int i=0;i<n;i++){
            answer[i] ="";
            for(int j =result[i];answer[i].length()< n;j/=2 ) {
                if(j%2 ==0) answer[i] = " ".concat(answer[i]);
                else answer[i] = "#".concat(answer[i]);
            }
        }

    }
}
