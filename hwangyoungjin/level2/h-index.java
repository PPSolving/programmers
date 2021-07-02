import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        if(citations.length == 1){
            return 1;
        }
        
        Arrays.sort(citations);
        
        int max = 0;
        
        //맨 처음 인덱스전 까지 개수 파악
        for(int h=0; h<citations[0]; h++){
            //h가 뒤에 남은개수 보다 작고
            if(h <= citations.length){
                //조건만족
                if(h > max) max = h;
            }
        }
        
        for(int i=0; i<citations.length; i++){
            int num = citations[i];
            int rest = citations.length-i; //i번째 포함 남은개수
            if(num <= rest && i <= num){ //i는 앞의 개수
                //조건만족
                if(num > max ) max = num;
                
                if(i+1 == citations.length) break;
                
                for(int j=num+1; j<citations[i+1]; j++){
                    //rest-1 : i번째 미포함 남은개수
                    if(j <= rest-1 && i+1 <= j){
                        //조건만족
                        if(j > max) max = j;
                    }
                }
            } else{
                break;
            }   
        }
        
        return max;
    }
}