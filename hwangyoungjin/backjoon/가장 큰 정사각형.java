package samsung.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1915 {
    static int N,M;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        dp = new int[N][M];
        int max = 0;
        sc.nextLine();
        for(int row = 0; row<N; row++){
            String[] strArr = sc.nextLine().split("");
            for(int col=0; col<M; col++) {
                dp[row][col] = Integer.parseInt(strArr[col]);
                if(max < dp[row][col]) max = dp[row][col];
            }
        }
        for(int row = 1; row<N; row++){
            for(int col=1; col<M; col++){
                if(dp[row][col] != 1) continue;
                if(dp[row-1][col] < 1 || dp[row][col-1] < 1
                        || dp[row-1][col-1] < 1) continue;
                dp[row][col] += Math.min(dp[row-1][col-1], Math.min(dp[row-1][col],dp[row][col-1]));
                if(dp[row][col] > max) max = dp[row][col];
            }
        }
        System.out.println((max*max));
    }
}
