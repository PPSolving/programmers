class Solution {
    public int[] solution(int n, int m) {
        int r1 = n; 
        int r2 = m;
        int remain = m; // 나머지
        int q = 0; // 몫
        while(r2>0){ //r2가 0이 되면 r1이 gcd(n,m)
            q = r1/r2;
            remain = r1-q*r2;
            r1 = r2;
            r2 = remain;
        }
        
        //두 수의 곱은 두 수의 최대공약수와 최소공배수의 곱과 같다.
        int minimul = (n*m)/r1; //최소공배수 = 두수의 곱/최대공약수
        
        int[] answer = new int[]{r1,minimul};
        
        return answer;
    }
}