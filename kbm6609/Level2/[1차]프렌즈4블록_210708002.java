package Friends_4_Blocks;

import java.util.*;

public class Friends4Blocks_210708002 {
    public static void main(String[] args) {
        int m=4;
        int n=5;
        int answer =0;
        String[] board = {"CCAAA", "AAAAA", "AAAAA", "CCAAC"};

        HashMap<Integer, Integer> delpoint = new HashMap<>();
        int c;
        boolean flag =true;
        Vector<char[]> bor=new Vector<>();
        Stack<Character> st =new Stack<>();
        Stack<Integer> delline =new Stack<>();
        for(int i=0;i< board.length;i++) bor.add(board[i].toCharArray());

        while(true) {
            for (int i = 0; i < bor.size() - 1; i++) {
                c = 0;
                char[] ch = bor.get(i);
                for (int j = 0; j < ch.length - 1; j++) {
                    if (ch[j] == 'x') c++;
                    else if (ch[j] == ch[j + 1] && ch[j] == bor.get(i+1)[j] && ch[j] == bor.get(i+1)[j + 1]) {
                        delpoint.put(i * n + j, 1);
                        delpoint.put(i * n + j + 1, 1);
                        delpoint.put((i + 1) * n + j, 1);
                        delpoint.put((i + 1) * n + j + 1, 1);
                    }
                    if(j==ch.length-2 &&ch[j+1] == 'x') c++;
                }
                if (c == n)delline.add(i);
            }

            if(delpoint.size()==0) break;
            else{
                for(int i:delpoint.keySet()){
                    bor.get(i/n)[i%n] = 'x';
                }
                answer += delpoint.size();
                delpoint.clear();
            }
            for (int j = 0; j < n ; j++) {
                for (int i = 0; i < bor.size() ; i++) {
                    if (bor.get(i)[j] != 'x') st.push(bor.get(i)[j] );
                    bor.get(i)[j] ='x';
                }
                for (int i = bor.size()-1; i >=0 &&!st.isEmpty(); i--)  bor.get(i)[j] =st.pop();
            }
            while(!delline.isEmpty()){
                bor.remove((int)delline.pop());
            }
        }
        System.out.println(answer);

    }


}
