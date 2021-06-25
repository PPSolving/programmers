class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        int count =0;
        while(n != 1 && count < 500){
            if(n%2 == 0){
                n = n/2;
            } else{
                n = n*3+1;                
            }
            count++;
            answer++;
        }
        
        if(n != 1){
            answer = -1;
        }
        return answer;
    }
}