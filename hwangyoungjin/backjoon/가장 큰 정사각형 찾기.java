import java.util.*;

class Solution{
    public int solution(int [][]board){
        
        int max = 0;
        //1이 있는지 검사
        for(int i=0; i<board.length; i++){
            if(board[i][0] == 1){
                max = board[i][0];
                break;
            }
        }
        if(max != 1){
            for(int i=0; i<board[0].length; i++){
                if(board[0][i] == 1){
                    max = board[0][i];
                    break;
                }
            }            
        }
        
        for(int row=1; row<board.length; row++){
            for(int col=1; col<board[0].length; col++){
                if(board[row][col] != 1) continue;
                if(board[row-1][col-1] < 1 || board[row-1][col] < 1 
                   || board[row][col-1] < 1 ) continue;
                
                board[row][col] += Math.min(board[row-1][col-1], 
                                Math.min(board[row-1][col],board[row][col-1]));
                if(max < board[row][col]) max = board[row][col];
            }
        }
        return max*max;
    }
}