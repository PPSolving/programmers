import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        for(int y=1; y<land.length; y++){
           land[y][0] += Math.max(land[y-1][1],Math.max(land[y-1][2],land[y-1][3])); 
           land[y][1] += Math.max(land[y-1][0],Math.max(land[y-1][2],land[y-1][3])); 
           land[y][2] += Math.max(land[y-1][1],Math.max(land[y-1][0],land[y-1][3])); 
           land[y][3] += Math.max(land[y-1][1],Math.max(land[y-1][2],land[y-1][0]));                
        }
        
        for(int i=0; i<land[0].length; i++){
            int num = land[land.length-1][i];
            if(num > answer){
                answer = num;
            }
        }
        return answer;
    }
}