import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        //board를 탐을 list
        ArrayList<Stack<Integer>> list = new ArrayList<>();
        //0번째는 사용X
        list.add(new Stack<Integer>());
        
        for(int i=1; i<=board.length; i++){
            list.add(new Stack<Integer>());
        }
        
        //board 값 0이 아닌것 만 담기
        for(int x=0; x<board.length; x++){
            for(int y=board[0].length-1; y>=0; y--){
                if(board[y][x] !=0){
                    list.get(x+1).add(board[y][x]);                    
                }
            }
        }
        
        int answer = 0;
        
        //인형 담을 바구니
        Stack<Integer> bucket = new Stack<>();
        
        
        //이동하면서 담기
        for(int i=0; i<moves.length; i++){
            //꺼낼곳이 비어있다면
            if(list.get(moves[i]).empty()){
                continue;
            }
            
            int doll = list.get(moves[i]).pop();
            
            //비어있다면 넣고 continue
            if(bucket.empty()){
                bucket.push(doll);
                continue;
            }
            
            int target = bucket.peek();
            
            //bucket안의 값과 같다면
            if(doll == target){
                bucket.pop(); //꺼내서 지우고
                answer += 2; 
            }else{ //다르다면
                bucket.push(doll);
            }
        }
        
        return answer;
    }
}