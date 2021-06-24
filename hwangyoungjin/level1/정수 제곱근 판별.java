class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long origin = (long) (Math.sqrt(n));
        
        if(n == origin*origin){
            answer = (origin+1)*(origin+1);            
        } else{
            answer = -1;
        }
        
        return answer;
    }
}