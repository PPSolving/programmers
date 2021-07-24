import java.util.*;

class Pos implements Comparable<Pos>{
    int idx;
    int dist;
    Pos(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Pos p){
        return this.dist - p.dist;
    }
}

class Solution {
    public int solution(String name) {
        int answer=0;
        int len = name.length();
        char stand = 'N'; //78
        int[] upDown = new int[len];
        
        LinkedList<Pos> posList = new LinkedList<>();
        
        for(int i=0; i<len; i++){
            char ch = name.charAt(i);
            if(ch >= 'N') upDown[i] = ('Z'- ch) + 1;
            else upDown[i] = ch - 'A';
            
            //방문필요한 경우 이므로
            if(upDown[i] != 0 || i == 0){
                int d = i-0 > len/2 ? len-(i) : i;
                posList.add(new Pos(i,d));
            }
        }
    
        Collections.sort(posList);
        Pos cur = posList.poll(); // 맨처음
        answer += upDown[cur.idx];
        answer += cur.dist;
        
        while(posList.size() > 0){
            
            //현재위치에서 가장 빠른 위치로 
            cur = posList.poll();
            answer += upDown[cur.idx];
            answer += cur.dist;
            
            //현재 위치 기준 거리 값 갱신
            for(Pos p : posList){
                int d = (int)(Math.abs(cur.idx-p.idx));
                int dis = d > len/2 ? len-d : d;
                p.dist = dis;
            }
            
            //정렬
            Collections.sort(posList);
        }        
        
        return answer;
    }
}