class Solution{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        
        // a<b 상태로 만들기
        if(a > b){
            int t = a;
            a = b;
            b = t;
        }
        
        while(a != b){
            if(b%2 == 0 && b-a == 1){
                break;
            }
            
            //홀수이면 2로 나누고 +1
            a = a%2 == 0 ? a/2 : a/2+1;
            if(a == 0) a=1; //1번은 이겨도 계속 1번이므로

            b = b%2 == 0 ? b/2 : b/2+1;

            round++;    
        }
        
        return round;
    }
}