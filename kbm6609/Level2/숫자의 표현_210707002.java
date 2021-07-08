package Representation_Of_Numbers;
//주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다 -정수론 .
public class RepresentationOfNumbers_210707002 {
    static int c=0;
    public static void main(String[] args) {
        int n=15;
        int answer;
        for(int i=1;i<=n;i++)
             run(n,i,i);
        answer =c;
        System.out.println(answer);

    }
    static void run(int n,int i, int sum){
        if(sum==n){
            c++;
        }
        else if(sum>n){
            return;
        }
        run(n, i+1,sum+i+1);
    }
}
