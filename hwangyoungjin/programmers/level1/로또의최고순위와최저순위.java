import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(win_nums);
        Arrays.sort(lottos);
        
        ArrayList<Integer> winList = new ArrayList<>();
        ArrayList<Integer> lottoList = new ArrayList<>();
        
        int zeroNum = 0;        
        for(int i=0; i<win_nums.length; i++){
            winList.add(win_nums[i]);
            if(lottos[i] != 0){
                lottoList.add(lottos[i]);
            } else{
                zeroNum ++;            
            }
        }
        
        ArrayList<Integer> tmpList = (ArrayList<Integer>)lottoList.clone();
        
        int bottomLevel = 7;
        
        //System.out.println("zeroNum : "+ zeroNum);
        
        //당첨번호 확인
        for(Integer num : tmpList){
            if(winList.contains(num)){
                winList.remove(num);
                bottomLevel--;
            } 
            lottoList.remove(num);
        }
        
        int topLevel = bottomLevel;
        
        //당첨가능성 파악하기
        if(zeroNum > 0){
            topLevel -= winList.size() >= zeroNum ? zeroNum : winList.size();
        }
    
        if(bottomLevel == 7){
            bottomLevel = 6;
        }
        if(topLevel == 7){
            topLevel = 6;
        }
        
        
        int[] answer = new int[2];
        answer[0] = topLevel;
        answer[1] = bottomLevel;
        
        return answer;
    }
}