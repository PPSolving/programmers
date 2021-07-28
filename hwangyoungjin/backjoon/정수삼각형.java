package samsung.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1932 {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        dp= new int[N+1][N+1];
        int[] tmp = new int[N+1];

        for(int row=1; row<=N; row++){
            for(int col=1; col<=row; col++){
                dp[row][col] = sc.nextInt();
            }
        }
        //dp
        for(int row=2; row<=N; row++){
            for(int col=1; col<=row; col++){
                if(col == 1) dp[row][col] += dp[row-1][col];
                else if(col==row) dp[row][col] += dp[row-1][col-1];
                else dp[row][col] += Math.max(dp[row-1][col-1],dp[row-1][col]);
            }
        }

        Arrays.sort(dp[N]);
        System.out.println(dp[N][N]);

    }
}
