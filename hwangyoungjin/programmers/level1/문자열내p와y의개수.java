class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String newStr = s.toLowerCase();
        
        int pCount = 0;
        int yCount = 0;
        
        for(int i=0; i<s.length(); i++){
            char ch = newStr.charAt(i);
            if(ch == 'p'){
                pCount++;
            } else if(ch == 'y'){
                yCount++;
            }
        }
        
        if(pCount == 0 && yCount ==0){
            return true;
        }
        if(pCount != yCount){
            return false;
        }
        
        return answer;
    }
}