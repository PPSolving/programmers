package Translating_Parentheses;

import java.util.*;

public class TranslatingParentheses_210702001 {
    public static void main(String[] args) {
        String p = "()))((()";
        String answer;

        char[] tmp =new char[p.length()];
        int findex=0,lindex=tmp.length-1;
        Queue<Character> v = new LinkedList<>();
        Deque<Character> u = new ArrayDeque<>();
        for (char i : p.toCharArray()) v.add(i);
        while(v.size() !=0) {
            int rc = 0, lc = 0;
            boolean flag= true;
           while(!v.isEmpty()) {
                u.addLast(v.poll());
                if(u.peekLast()=='(') {
                    lc++;
                    flag =false;
                }
                else {
                    rc++;
                    flag =true;
                }
                if(rc==lc)break;
            }
            if(flag)
                while(!u.isEmpty()) tmp[findex++] =u.pollFirst();
            else{
                u.pollFirst();
                u.pollLast();
                tmp[findex++] ='(';
                while(!u.isEmpty()) {
                    tmp[lindex--] = u.pollLast()=='('?')':'(';
                }
                tmp[lindex--] =')';
            }

        }
        answer =new String(tmp);
        System.out.println(answer);
    }
}
