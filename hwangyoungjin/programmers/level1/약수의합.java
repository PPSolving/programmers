class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sqrt = (int) Math.sqrt(n);
        
        for(int i=1; i<=sqrt; i++){
            if(n%i == 0){
                int quo = (int)(n/i);
                if(quo == i){
                    answer += i;
                    continue;
                }
                answer += (i+quo);
            }
        }
        
        return answer;
    }
}