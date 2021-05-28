import java.util.Arrays;
class Solution {
    //최대 몇개의 부서에게 지원해 줄 수 있는지
    public int solution(int[] d, int budget) {
        //Greedy
        Arrays.sort(d);
        int answer = 0;
        for(int i : d){
            if(budget >= i){
                budget -= i;
                answer++;            
            }
        }
        return answer;
    }
}