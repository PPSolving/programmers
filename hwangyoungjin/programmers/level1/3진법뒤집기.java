class Solution {
    public int solution(int n) {
        StringBuffer buf = new StringBuffer();
        double num = n;
        double value = 1;
        double quo = 0;
        int check = 0;
        
        //3진법으로 변환
        for(int i=16; i>=0; i--){
            quo = 0;
            value = Math.pow(3,i);        
            quo = num < value ? 0 : num/value;
            
            if(quo > 0){
                check =1;
                quo = (int)quo;
                buf.append(String.valueOf((int)quo));
                num-= quo*value;
            } else if(check == 1){
                buf.append(0);
            }
        }
        
        //3진법 reverse
        String reverse = buf.reverse().toString();
        
        int answer = 0;
        int p = reverse.length();
        for(int i=0; i<reverse.length(); i++){
            int su = reverse.charAt(i)-'0';
            --p;
            if( su > 0 ){
                answer += ((int)(Math.pow(3,p)))*su;
            }
        }
        
        return answer;
    }
}