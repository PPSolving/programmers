package crane_claw_machine;

import java.util.ArrayList;
import java.util.Stack;

public class craneclawmachine_210521002 {
    public static void main(String[] args) {
        int[][] board={
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves={1,5,3,5,1,2,1,4};

        int answer=0;
        int tmp;
        ArrayList<Stack<Integer>> list =new ArrayList<>();
        for(int i=0;i<board[0].length;i++) list.add(new Stack<Integer>());

        for(int j=0;j< board[0].length;j++) {
            for(int i=board.length-1;i>=0;i--){
                if(board[i][j]==0) break;
                else list.get(j).push(board[i][j]);
            }
        }

        Stack<Integer> st =new Stack<>();

        for(int i:moves){
            if(!(list.get(i-1).empty())) {
                tmp =list.get(i-1).pop();
                if(!(st.empty())&& st.peek() == tmp) {
                    st.pop();
                    answer++;
                }
                else st.push(tmp);
            }
        }


        System.out.println(answer*2);
    }
}
