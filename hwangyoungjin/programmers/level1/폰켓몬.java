import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            //개수 추가 - 없는 경우 해당 개수 default로 0 넣고 + 1
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        //개수 추가하기
        int count = 0;
        int max = nums.length/2;
        List<Integer> list = new ArrayList<>();
        
        while(count < max){
            for(Integer pokemon : map.keySet()){
                if(count==max){
                    break;
                }
                //개수가 1개라도 있고
                if(map.get(pokemon) > 0){
                    //포함하지 않았던 포켓몬 종류이면
                    if(!list.contains(pokemon)){
                        //개수 감소
                        map.put(pokemon,map.get(pokemon)-1);
                        list.add(pokemon);
                        answer++; //새로운 종류 이므로
                        count++; // 현재 개수
                    }else{ //이미 있었던 폰켓몬이면 
                        //개수 감소 후 현재 개수만 추가
                        map.put(pokemon,map.get(pokemon)-1);
                        count++;
                    }
                }
            }
        }
        return answer;
    }
}