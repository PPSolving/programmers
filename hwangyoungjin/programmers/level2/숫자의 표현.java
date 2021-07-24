class Solution {
    public int solution(int n) {
        int answer = 1; //n일떄 경우의 수 1
        int start = 0;
        int limit = n;
        while(start<(limit/2)){
            int sum =0;
            start++; //1,2,3,4 ...
            n = limit;
            int i = start;
            while(i<=n){
                sum += i;
                n -= i;
                if(n == 0){
                    answer++;
                    break;
                }
                i++;
            }            
        }
        return answer;
    }
}