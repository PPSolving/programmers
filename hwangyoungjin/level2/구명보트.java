import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i : people){ 
            list.add(i);        
        }
        
        Collections.sort(list);
        
        while(list.size() > 0){
            if(list.size() == 1) {
                answer ++;
                break;
            }
            int first = list.pollFirst();
            if(first > limit/2){
                answer++;
                answer += list.size();
                break;
            }
            //list는 limit/2 보다 작고 2개이상
            int second = list.pollLast();
            //뒤부터 검사
            while((second+first) > limit){
                answer++; //맨뒤 혼자 배에 태운다
                if(list.size() == 0) break;
                second = list.pollLast();
            }
            //작으면 한배에 태운다
            answer++;
        }
        
        return answer;
    }
}