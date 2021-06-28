import java.util.*;

class Print implements Comparable<Print>{
    int num;
    boolean location;
    Print(int num, boolean location){
        this.num = num;
        this.location = location;
    }
    
    @Override
    public int compareTo(Print o){
        return -1*(this.num - o.num);
    }
    
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> pq = new PriorityQueue<>(); // 우선순위 높은 Print
        Queue<Print> queue = new LinkedList<>(); // Print 출력 순서 
        
        //pq, queue의 저장
        for(int i=0; i<priorities.length; i++){
            boolean target = i == location ? true : false;
            Print p = new Print(priorities[i],target);
            pq.add(p);
            queue.add(p);
        }
        
        Print max = pq.poll();
        while(true){
            
            Print p = queue.poll();
            answer++;
            
            //우선순위 가장 높은 프린트물 이라면  
            if(p.num == max.num){
                max = pq.poll();
                
                if(p.location){ //출렸했는데 location 이면 break
                    break;
                }
            } else{ // 프린트 X
                answer--; //다시 뒤로가므로
                queue.add(p);
            }
            
        }
        return answer;
    }
}