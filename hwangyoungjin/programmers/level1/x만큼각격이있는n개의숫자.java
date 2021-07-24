class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int count = 0;
        long num = x;
        long interval = x;
        while(count<n){
            answer[count++] = num;
            num += interval;
        }
        return answer;
    }
}