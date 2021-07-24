import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int check = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int quo = (int)(arr[i]/divisor);
            int res = (int) (arr[i]%divisor);
            if(quo > 0 && res == 0){
                check = 1;
                list.add(arr[i]);
            }
        }
        
        Collections.sort(list);
        
        int[] answer = {};
        if(check == 0){
            answer = new int[1];
            answer[0] = -1;
        
        } else{
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }          
        }
        return answer;
    }
}