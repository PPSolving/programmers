package Compression;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Compression_210716002 {
    public static void main(String[] args) {
        String msg="TOBEORNOTTOBEORTOBEORNOT";

        HashMap<String, Integer> hs = new HashMap<>();
        int[] answer = {};
        StringBuilder str =new StringBuilder();
        Queue<Integer> qu =new LinkedList<>();
        int index =26;
        for (int i = 1; i <= 26; i++)  hs.put(String.valueOf((char)('A'+i-1)),i);
        for (int i = 0; i < msg.length(); i++) {
           String s=msg.substring(i,i+1);
            if(!hs.containsKey(str.toString()+s)){
                qu.add(hs.get(str.toString()));
                hs.put(str.toString() + s, ++index);
                str.delete(0,str.length());
            }
            str.append(s);
        }
        qu.add(hs.get(str.toString()));
        answer=new int[qu.size()];
        for (int i = 0; i < answer.length; i++) answer[i] =qu.poll();
    }
}
