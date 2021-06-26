package Multiplication_Of_Matrices;

public class MultiplicationOfMatrices_210626002 {
    public static void main(String[] args) {
        int[][] arr1={{1,4},{3,2},{4,1}};
        int[][] arr2={{3,3},{3,3}};

        int[][] answer =new int[arr1.length][arr2[0].length];
        int sum;
        for(int i=0;i<answer.length;i++){
            for (int j = 0; j < answer[0].length; j++) {
                sum=0;
                for(int k=0;k<arr1[i].length;k++) sum += arr1[i][k]*arr2[k][j];
                answer[i][j] =sum;
            }
        }
    }
}
