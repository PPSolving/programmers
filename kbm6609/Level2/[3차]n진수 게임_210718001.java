package N_Binary_Game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NBinaryGame_210718001 {
    public static void main(String[] args) {
        int n = 2; //진법
        int t = 4;  //미리 구할 숫자의 개수
        int m = 2;  // 인원
        int p = 1; // 순서

        p--;
        char[] ch =new char[t];
        int aindex =0;
        int chindex =0;
        for(int i=0;chindex != t;i++){
            char[] str =run(n,i);
            for(int j=0;j<str.length;j++,aindex++){
                if(aindex%m ==p) {
                    ch[chindex++] = str[j];
                    if(j+m-1<str.length) aindex+=m-1;
                    else aindex += str.length - j - 1;
                    j+=m-1;
                }
                if(chindex ==t) break;
            }
        }
        System.out.println(String.valueOf(ch));

    }
    static char[] run(int n,int num){
        Queue<Character> st =new LinkedList<>();
        if(num==0) return new char[]{'0'};
        while(num >0){
            int ch = num % n;
            num/=n;
            if(ch >=10) ch += 'A' - 10;
            else ch += '0';
            st.add((char)ch);
        }
        char[] str =new char[st.size()];
        while (!st.isEmpty()) str[st.size()-1] = st.poll();
        return str;
    }
}
