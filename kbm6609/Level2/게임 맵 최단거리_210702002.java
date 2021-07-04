package Game_Map_Shortest_Distance;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance_210702002 {

    public static void main(String[] args) {
        int[][] maps =
                {
                        {1,1,1,0,1},
                        {1,1,1,0,1},

                };
        int c=1;
        int m=maps.length;
        int n= maps[0].length;
        boolean[][] check =new boolean[m][n];
        boolean flag= true;
        Queue<Integer[]> qe =new LinkedList<>();
        int x,y;
        int nx,ny;
        qe.add(new Integer[]{0,0});
        check[0][0] =true;
        int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
        while(flag&&!qe.isEmpty()){
            c++;
            int rt=qe.size();
            for(int j=0;j<rt;j++){
                Integer[] xy =qe.poll();
                y=xy[0];
                x=xy[1];
                for(int i=0;i<4;i++){
                    nx = x+move[i][1];
                    ny = y+move[i][0];
                    if(!(ny>=maps.length||ny<0||nx>=maps[0].length||nx<0||check[ny][nx]||maps[ny][nx]==0)){
                        if(nx==n-1&&ny==m-1){
                            flag =false;
                            break;
                        }
                        else{
                            qe.add(new Integer[]{ny, nx});
                            check[ny][nx] = true;
                        }
                    }
                }
                if(!flag) break;
            }
            for(Integer[] q : qe){
                System.out.println(q[0]+" "+q[1]);
            }
            System.out.println("\n");
        }
        int answer ;
        if(flag) answer= -1;
        else answer =c;
        System.out.println(answer);
    }

}
