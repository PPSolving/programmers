class Solution {
    public String solution(int n, int t, int m, int p) {
        int number = 2;
        StringBuffer numsBuf = new StringBuffer();
        numsBuf.append("0");
        numsBuf.append("1");
        
        while(numsBuf.length() < m*t){ //m*t개 까지만
            int start = number;
            StringBuffer buf = new StringBuffer();
            while(start >= n){
                if(start%n >= 10){
                    buf.append(""+(char)((start%n%10)+'A'));
                } else buf.append((start%n)+"");
                start /= n;
            }
            if(start != 0){
                if(start >= 10){
                    buf.append(""+(char)((start%10)+'A'));
                }else buf.append(start+"");
            }
            numsBuf.append(buf.reverse().toString());  
            number++;
        }
        
        StringBuffer answer = new StringBuffer();
        int selIdx = p-1;
        while(answer.length() < t){
            answer.append(numsBuf.charAt(selIdx));
            selIdx += m;
        }
        return answer.toString();
    }
}