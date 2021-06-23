class Solution {
    public String solution(String s, int n) {
        char[] ch = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            ch[i] = s.charAt(i);
            if (ch[i] <= 'Z' && ch[i] + n > 'Z'){
                int k = ch[i] + n - 'Z';
                ch[i] = 'A';
                ch[i] += (k-1);                
            }
            else if(ch[i] + n > 'z'){
                int k = ch[i] + n - 'z';
                ch[i] = 'a';
                ch[i] += (k-1);
            }
            else if(ch[i] != ' '){
                ch[i] += n;
            }
        }
        
        String answer = new String(ch);
        return answer;
    }
}