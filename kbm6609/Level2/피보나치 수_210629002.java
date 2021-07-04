package Fibonacci_Count;

public class FibonacciCount_210629002 {
    public static void main(String[] args) {
        int n=10000;
        int answer;
        if(n<=1) answer = n;
        else {
            long r1 = 0, r2 = 1;
            long num=0;
            for(int i=2;i<=n;i++){
                num = r2+r1;
                r1=r2%1234567;
                r2 =num%1234567;
            }
            answer =(int)(num%1234567);
        }
        System.out.println(answer);

    }
}
