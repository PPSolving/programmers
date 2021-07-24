import java.util.ArrayList;
class Solution {
    public int[] solution(long n) {
        
        ArrayList<Integer> intList = new ArrayList<>();
        
        
        while(n > 0){
            int num = (int) (n%10);
            n = n/10;
            intList.add(num);
        }    

        int[] answer = new int[intList.size()];

        for(int i =0; i<intList.size(); i++){
            answer[i] = intList.get(i);
        }
        
        return answer;
    }
}