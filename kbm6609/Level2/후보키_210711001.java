package Candidate_Key;

import java.util.*;

public class CandidateKey_210711001 {
    public static void main(String[] args) {
        String[][] relation= {
                {"100", "100", "ryan", "music", "2"},
        {"200", "200", "apeach", "math", "2"},
            {"300", "300", "tube", "computer", "3"},
                {"400", "400", "con", "computer", "4"},
                    {"500", "500", "muzi", "music", "3"},
                        {"600", "600", "apeach", "music", "2"}};

        int answer =0;
        HashSet<String> re =new HashSet<>();
        Queue<int[]> qu =new LinkedList<>();
        Vector<HashSet<Integer>> end = new Vector<>();
        for (int i = 0; i < relation[0].length; i++) {
            qu.add(new int[]{i});
        }
        while(!qu.isEmpty()){
          int[] in =qu.poll();
          Arrays.sort(in);
            for(int i=0;i<in.length;i++) System.out.print(in[i]);
            System.out.println();
          boolean flag =true;
            for (int i = 0; i < end.size(); i++) {
                int n=0;
                for (int j = 0; j < in.length; j++) {
                    if(end.get(i).contains(in[j])){
                        n++;
                    }
                }
                if(n==end.get(i).size()){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("이미 존재하는거로 만들수잇지않은 후보키");
                for (int i = 0; i < relation.length; i++) {
                    String str ="";
                    for (int j = 0; j < in.length; j++) {
                        str+=relation[i][in[j]]+"A";
                    }
//                    System.out.println(str);
                    if(re.contains(str))break;
                    else re.add(str);
                }
                if(re.size() == relation.length) {
                    System.out.println("가능한 후보키");
                    HashSet<Integer> t= new HashSet<>();
                    for(int i:in) t.add(i);
                    end.add(t);
                }
                else{
                    System.out.println("가능하지 않은 후보키");
                    for(int i=in[in.length-1]+1;i< relation[0].length;i++) {
                        int[] k =Arrays.copyOf(in,in.length+1);
                        k[k.length-1] =i;
                        qu.add(k);
                    }

                }
                re.clear();
            }
            else {
                System.out.println("이미 존재하는거로 만들수잇는 후보키");
            }
        }
        System.out.println(end.size());
    }
}

