import java.util.*;

class Point{
    int y;
    int x;
    int count;
    Point(int y, int x, int count){
        this.y = y;
        this.x = x;
        this.count = count;
    }
}

class Solution {
    
    static boolean result = false;
    
    public int solution(int[][] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        int answer = bsf(visit,maps);
        return answer;
    }
    
    public static int bsf(boolean[][] visit, int[][] maps){
        Queue<Point> queue = new LinkedList<>();
        int count = 1;
        queue.add(new Point(0,0,count));
        
        //동 서 남 북
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            for(int i=0; i<directions.length; i++){
                int nextY = p.y+directions[i][0];
                int nextX = p.x+directions[i][1];
                
                if(nextY == maps.length-1 && nextX == maps[0].length-1){
                    return p.count+1;
                }
            
                if( 0 <= nextY && nextY < maps.length 
                   && 0 <= nextX && nextX < maps[0].length 
                   && !visit[nextY][nextX]
                   && maps[nextY][nextX] == 1){
                    visit[nextY][nextX] = true;
                    queue.add(new Point(nextY, nextX,p.count+1));
                }
            }
        } // while end
        //path 못찾음
        return -1;
    }
}