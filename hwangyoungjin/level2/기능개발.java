import java.util.ArrayList;
class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] answer = {};
        ArrayList<Integer> products = new ArrayList<>();
        
        /** init **/
        int count = 1; //Count 시작이므로 1 부터
        int check = (100-progresses[0]) % speeds[0];
        int checkDay = (100-progresses[0]) / speeds[0];
        int minDay = check == 0 ? checkDay : checkDay + 1;
        
        /** 하나씩 꺼내면서 소요 일 비교하면서 count**/
        for(int i=1; i<progresses.length; i++){
            
            check = (100-progresses[i]) % speeds[i];
            checkDay = (100-progresses[i]) / speeds[i];
            int day = check == 0 ? checkDay : checkDay + 1;
            
            if(minDay >= day){
                count++;
            }else{
                minDay = day;
                products.add(count);
                count = 1; // Count 재시작이므로 1 부터
            }
        }
        
        products.add(count); // 마지막 추가
    
        answer = new int[products.size()];
   
        int idx = 0;
    
        for(int i : products){
            answer[idx++] = i;
        }
    
        return answer;
    }
}