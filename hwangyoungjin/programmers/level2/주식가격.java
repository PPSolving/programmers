import java.util.Stack;
class Price{
    int sec;
    int value;
    Price(int sec,int value){
        this.sec = sec;
        this.value = value;
    }
}
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Price> stack = new Stack<>();
        
        for(int i=0; i<prices.length-1; i++){
            
            Price curP = new Price(i+1,prices[i]);
            
            if(stack.isEmpty()){
                stack.push(curP);
                continue;
            }       
                        
            while(!stack.isEmpty()){
                Price p  = stack.pop();
                
                if(p.value <= curP.value) {
                    stack.push(p);
                    stack.push(curP);
                    break;
                }                
                answer[p.sec-1] = curP.sec-p.sec;
                
                //마지막 비교였다면 현재초 저장
                if(stack.isEmpty()) stack.push(curP); 
            }
        }
        
        while(!stack.isEmpty()){
            Price p = stack.pop();
            answer[p.sec-1] = prices.length-p.sec;
        }
        //마지막은 항상 0
        answer[prices.length-1] = 0;
        
        return answer;
    }
}