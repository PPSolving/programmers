class Solution {
    
    public int[] solution(int m, int n, int[][] picture) {
        
        boolean[][] visit = new boolean[m][n];
        int maxNum = 0;
        int countArea = 0;
        
        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                int count = 0;
                if(!visit[y][x] && picture[y][x] != 0 ){
                    countArea ++;
                    count = dfs(m,n,visit, picture,y,x,count);
                    if(count > maxNum){
                        maxNum = count;
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = countArea;
        answer[1] = maxNum;
        return answer;
    }
    
    public static int dfs(int m,int n,boolean[][] visit,int[][] picture,int y,int x,int count){
        
        visit[y][x] = true;
        count++;
        
        //동서남북
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0; i<direction.length; i++){
            int curY = y+direction[i][0];
            int curX = x+direction[i][1];
            if(0<=curY && curY < m
              && 0<=curX && curX < n
              && !visit[curY][curX]
              && picture[curY][curX] != 0
              && picture[curY][curX] == picture[y][x]){
                count = dfs(m,n,visit,picture,curY,curX,count);
            }
        }
        return count;       
    }
}