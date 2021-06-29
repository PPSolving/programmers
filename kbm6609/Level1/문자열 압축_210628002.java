package Compression_Of_String;

import java.util.Stack;

public class CompressionOfString_210628002 {
    public static void main(String[] args) {
        String s ="a";


        Stack<String> str =new Stack<>();
        Stack<Integer> cs =new Stack<>();
        int c;
        String ns;
        int a,min=1000;
        if(s.length()==1){
            min=1;
        }
        else {
            for (int i = 1; i <= s.length() / 2; i++) {
                c = 1;
                for (int j = 0; j < s.length(); j += i) {
                    if (str.empty()) {
                        str.push(s.substring(j, j + i));
                    } else {
                        if (j + i > s.length()) {
                            ns = s.substring(j);
                        } else {
                            ns = s.substring(j, j + i);
                        }
                        if (str.peek().equals(ns)) {
                            c++;
                            if (j + i >= s.length()) {
                                cs.push(c);
                            }
                        } else {
                            str.push(ns);
                            cs.push(c);
                            c = 1;
                            if (j + i >= s.length()) {
                                cs.push(c);
                            }
                        }
                    }
                }
                a = 0;
                while (!cs.empty()) {
                    int q = cs.pop();
                    if (q >= 2 && q <= 9) a += 1;
                    else if (q >= 10 && q <= 99) a += 2;
                    else if (q >= 100 && q <= 999) a += 3;
                    else if (q == 1000) a += 4;
                }
                a += (str.size() - 1) * i + str.peek().length();
                if (min > a) min = a;
                str.clear();
            }
        }
        System.out.println(min);

    }
}
