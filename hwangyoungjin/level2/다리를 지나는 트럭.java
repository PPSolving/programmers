import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> rest = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++){
            rest.add(truck_weights[i]);
        }
        
        Queue<Integer> bridge = new LinkedList<>();
        //bridge - 모두 0으로 채우기
        for(int i=0; i<bridge_length; i++){
            bridge.add(0);
        }
        
        int time = 0; //걸린시간
        int totalWeight = 0; //현재 다리무게
        
        //다리에 아무도 없을때 까지
        while(!bridge.isEmpty()){
            time++;
            //다리에서 나오고
            int num = bridge.poll();
            totalWeight -= num;
            
            //다리에 들어갈 차량이 남았고 대기 트럭이 있으면
            if(bridge.size() < bridge_length && !rest.isEmpty()){
                
                //다리무게 체크 후
                int testWeight = totalWeight+rest.peek();
                if(testWeight <= weight){ //진입
                    int w = rest.poll();
                    totalWeight += w;
                    bridge.add(w);
                    
                } else { //대기
                    bridge.add(0); 
                }
            }
        }
        return time;
    }
}