package Kth_number;

import java.util.Arrays;

public class Kthnumber_210524001 {
    public static void main(String[] args) {
        int[] array={1, 5, 2, 6, 3, 7, 4};
        int[][] commands={{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        int answer[] = new int[commands.length];
        for(int i=0;i< commands.length;i++){
            int[] tmp =Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(tmp);
            answer[i] =tmp[commands[i][2]-1];
        }

        for(int i:answer) System.out.println(i);
    }
}
