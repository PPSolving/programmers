package samsung.backjoon;

import java.util.Scanner;

public class Ditionary1256 {

    static int[][] dp;
    static int K;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        K = scan.nextInt();

        dp = new int[(N+M)+1][(N+M)+1];
        if(combination((N+M),M) < K) System.out.println("-1");
        else{
            StringBuffer buf = new StringBuffer();
            query((N+M),M,K,buf);
            System.out.println(buf.toString());
        }
    }

    public static void query(int n, int m, int k, StringBuffer buf){
        if(m==0){
            while(n>0){
                n--;
                buf.append("a");
            }
            return;
        } else if(n==m){
            while(m>0){
                m--;
                buf.append("z");
            }
            return;
        }

        //a선택시 길이
        int remainLen = combination(n-1,m);
        if(remainLen >= k){ //a선택
            buf.append("a");
            query(n-1,m,k,buf);
        } else{ //z 선택
            buf.append("z");
            query(n-1,m-1,k-remainLen,buf);
        }
    }

    //dp갱신
    public static int combination(int n, int r){
        if(n == r || r ==0){
            return 1;
        } else if (dp[n][r] != 0){ //hit된 값 caching
            return dp[n][r];
        } else {
            return dp[n][r] = Math.min(K, combination(n-1,r-1) + combination(n-1,r));
        }
    }
}
