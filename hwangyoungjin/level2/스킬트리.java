import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
       
        String[] rule = skill.split("");
        Queue<String> qu = new LinkedList<>();
        for(String sk : rule){
            qu.add(sk);
        }
        
        for(int i=0; i<skill_trees.length; i++){
            String[] skils = skill_trees[i].split("");
            boolean result = true;
            Queue<String> queue = new LinkedList<>(qu);
            for(String cur : skils){
                String compare = queue.peek();
                //cur이 skilList의 상관없으면 skip
                if(!queue.contains(cur)) continue;
                
                //포함하는데 compare와 다르면 false후 break;
                if(!cur.equals(compare)){
                    result = false;
                    break;
                } else{ //같으면 poll
                    queue.poll();
                    if(queue.isEmpty()) break; //검사 끝났으면 종료
                }
            }
            //true인 경우만 answer++
            if(result) answer++;
            
        }
        return answer;
    }
}