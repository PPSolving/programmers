package Tuple;

import java.util.HashMap;

public class Tuple_210701002 {
    public static void main(String[] args) {
        String s ="{{123}}";
        char[] tmp =s.toCharArray();
        HashMap<Integer, HashMap<Integer,Integer>> mainhs= new HashMap<>();
        String[] str ;
        int startindex=0;
        int endindex=0;
        for(int i=1;i<tmp.length-1;i++){
            if(tmp[i] =='{'){
                startindex = i;
            }
            else if(tmp[i] =='}') {
                endindex=i;
                str =s.substring(startindex+1,endindex).split(",");
                HashMap<Integer, Integer> hs =new HashMap<>();
                for(String k :str){
                    hs.put(Integer.valueOf(k),1);
                }
                mainhs.put(str.length,hs);
            }
        }
        int[] answer =new int[mainhs.size()];
        for(int i=answer.length-1;i>=0;i--){
            if(i >0){
                for(Integer j:mainhs.get(i).keySet()) mainhs.get(i+1).remove(j);
            }
            for(Integer j:mainhs.get(i+1).keySet()) answer[i] =j;
        }


        for(int i:answer) System.out.print(i+" ");
    }
}
