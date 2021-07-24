class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long s = 0;
        long e = 0;

        if(a>b){
            s = b;
            e = a;
        }else{
            s = a;
            e = b;    
        }
        for(long i=s; i<=e; i++){
            answer += i;
        }
        return answer;
    }
}