import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        Queue<String> queue = new LinkedList<>();
        if(cacheSize == 0){
            return cities.length*5;
        }
        for(String s : cities){
            String str = s.toUpperCase();
            //hit
            if(queue.contains(str)){
                queue.remove(str);
                queue.add(str);
                time+=1;
                continue;
            }
            //miss
            if(queue.size() == cacheSize){
                String ss = queue.poll();
            }
            queue.add(str);
            time += 5;
        }
        return time;
    }
}