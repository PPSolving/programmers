class Solution {
    public int solution(int n) {

        int answer = 0;

        if(n == 2 ){
            return 1;
        } else if(n == 3){
            return 2;
        } 
        
        //5이상인 경우 2,3은 기본적으로 포함
        answer = 2;
        
        int check = 0;
        
        for(int i=5; i<=n; i++){
            
            check = 0;
            int sqrtNum = (int) Math.sqrt(i);
            
            for(int j=2; j<=sqrtNum; j++){
                if(i%j == 0){
                    check = 1;
                    break;
                }
            }
            
            if(check == 0){
                answer ++;    
            }
        }
        
        return answer;
    }
}