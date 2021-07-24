import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<Integer, Queue<String>> map = new HashMap<>(); 
        int select = 1; 
        for(int i=1; i<words.length; i++){
            select = select+1 > n ? 1 : select+1; // 2번 사용자부터 
            if(!map.containsKey(select)){
                map.put(select, new LinkedList<String>());
            }
            map.get(select).add(words[i]);
        }
        
        int turn = 1; 
        String beforeStr = words[0];
        int count = 1;
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
            
        while(true){
            turn = turn+1 > n ? 1 : turn+1; // 2번 사용자부터
            count = turn == 1 ? count+1 : count;
            
            //turn 차례의 사용자가 가진 단어 가져오기
            if(map.get(turn).isEmpty()){
                //더이상 가져올게 없다는건 정상 종료
                break;
            }
            String turnStr = map.get(turn).poll();
            
            //이전 값이랑 비교
            if(beforeStr.charAt(beforeStr.length()-1) != turnStr.charAt(0)
               || list.contains(turnStr)){
                answer[0] = turn;
                answer[1] = count;
                break;
            }
            beforeStr = turnStr;
            list.add(turnStr);
        }
        return answer;
    }
}