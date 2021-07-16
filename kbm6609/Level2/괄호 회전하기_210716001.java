package Rotate_Parentheses;

import java.util.*;

public class RotateParentheses_210716001 {
    public static void main(String[] args) {
        String s = "}}}(}";
        HashMap<Character, Character> hs = new HashMap<>();
        hs.put(')', '(');
        hs.put(']', '[');
        hs.put('}', '{');
        Stack<Character> st =new Stack<>();
        boolean flag;
        int answer =0;
        boolean f;
        char[] ch =s.toCharArray();
        int i;
        for (i = 0; i < ch.length; i++) {
            flag =true;
//            f= false;
//            answer=0;
            for (int j = 0; j < ch.length&&flag; j++) {
                if (!hs.containsKey(ch[(i + j) % ch.length])) {
                    st.push(ch[(i + j) % ch.length]);
//                    f =true;
                }
                else if (!st.isEmpty()&&st.peek() == hs.get(ch[(i + j) % ch.length]))   {
                    st.pop();
//                   if(f) {
//                       answer++;
//                       f = false;
//                   }
                }
                else  flag = false;
            }
            if(flag&& st.isEmpty()) answer++;
            st.clear();
        }
//        if(i>=ch.length){
//            answer = 0;
//        }
        System.out.println(answer);
    }
}