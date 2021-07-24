import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int idx = 0;
        numbers.add(arr[0]);
        for(int i =0; i<arr.length; i++){
            if(numbers.get(idx) != arr[i]){
                idx++;
                numbers.add(arr[i]);
            }
        }
        int[] answer = new int[numbers.size()];
        for(int i=0; i<numbers.size(); i++){
            answer[i] = numbers.get(i);
        }
        return answer;
    }
}