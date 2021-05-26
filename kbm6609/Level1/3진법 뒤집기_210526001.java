package Triad_Flip;

import java.util.Stack;

public class TriadFlip_210526001 {
    public static void main(String[] args) {
        int n=125;

        int answer =0;
        int th= 1;
        Stack<Integer> st = new Stack<>();
        for (int i = n; i > 0; i /= 3) st.push(i % 3);
        while(!st.empty()) {
            answer += st.pop()*th;
            th*=3;
        }
        System.out.println(answer);
    }
}
