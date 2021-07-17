class Solution {
    
    public long solution(int w, int h) {
        
        long answer = w*(long)h;
        long remove = 1;
        long max = 0;
        double m = 0;
        long curY = 1;
        long curX = 1;
        if(w > h){
            m = h/(double)w;
            max = w;
        } else{
            m = w/(double)h;
            max = h;
        }
        
        while(curX != max){
            
            if(curY-m*curX > 0){
                curX+=1;
                remove+=1;
            } else if(curY-m*curX < 0){
                curX+=1;
                curY+=1;
                remove+=2;
            } else{ // curY-m*curX = 0 
                remove+=1;
                curX+=1;
                curY+=1;
            }
        }
        
        return answer-remove;
    }
}