package unfinished_athlete;


import java.util.HashMap;

public class unfinishedathlete_210521001 {
    public static void main(String[] args) {
        String[] participant={"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion={"josipa", "filipa", "marina", "nikola"};

        HashMap<String,Integer> map = new HashMap<>();

        for(String i: participant) {
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
            //위 if else 문을  map.put(i,map.getOrDefault(i,0)+1); 한줄로 가능
        }
        for(String i: completion) {
            if(map.get(i)>1) map.put(i,map.get(i)-1);
            else map.remove(i);
        }
        String answer = "";
        for(String i:map.keySet()){
            answer =i;
        }
        System.out.println(answer);
    }
}

