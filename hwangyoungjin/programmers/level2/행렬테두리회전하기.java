import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        //init
        for(int y=0; y<rows; y++){
            for(int x=0; x<columns; x++){
                matrix[y][x] = (y)*columns + (x+1);
            }
        }
        
        int idx = 0;
        for(int[] point : queries){
            int min = rotation(point[0]-1,point[1]-1,point[2]-1,point[3]-1,matrix);
            answer[idx++] = min;
        }
        
        return answer;
    }
    public static int rotation(int sY, int sX, int eY, int eX, int[][] matrix){
        int tem = matrix[sY][sX];
        int min = tem;
        
        for(int y = sY+1; y<= eY; y++){
            if(matrix[y][sX] < min) min = matrix[y][sX];
            matrix[y-1][sX] = matrix[y][sX];
        }
        for(int x = sX+1; x<= eX; x++){
            if(matrix[eY][x] < min) min = matrix[eY][x];
            matrix[eY][x-1] = matrix[eY][x];
        }
        for(int y = eY-1; y>= sY; y--){
            if(matrix[y][eX] < min) min = matrix[y][eX];
            matrix[y+1][eX] = matrix[y][eX];
        }
        for(int x = eX-1; x>= sX+1; x--){
            if(matrix[sY][x] < min) min = matrix[sY][x];
            matrix[sY][x+1] = matrix[sY][x];
        }
        matrix[sY][sX+1] = tem;
        
        return min;
    }
}