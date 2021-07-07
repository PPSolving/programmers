import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numStrs = s.split(" ");
        int[] numbers = new int[numStrs.length];
        for(int i=0; i<numbers.length; i++){
            numbers[i] = Integer.parseInt(numStrs[i]);
        }
        Arrays.sort(numbers);
        answer = numbers[0] + " " +numbers[numbers.length-1];
        return answer;
    }
}