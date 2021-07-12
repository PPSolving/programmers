package Correct_Parentheses;

import java.util.Stack;

public class CorrectParentheses_210712001 {
    public static void main(String[] args) {
        String s=	")()(";
        Stack<Character> st =new Stack<>();
        boolean answer =true;
        for(char t : s.toCharArray()){
            if(t=='(') st.push(t);
            else {
                if(!st.isEmpty()&&st.peek() =='('){
                    st.pop();
                }else{
                    answer =false;
                    break;
                }
            }
        }
        if(!st.isEmpty()) answer =false;
        System.out.println(answer);
    }
}
