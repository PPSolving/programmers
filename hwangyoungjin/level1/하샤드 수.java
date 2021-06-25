class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int origin = x;
        int num = 0;
        while(x > 0){
            num += (x%10);
            x = x/10;
        }
        if(origin%num != 0){
            answer = false;
        }
       
        return answer;
    }
}