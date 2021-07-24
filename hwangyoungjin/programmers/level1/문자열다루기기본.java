class Solution {
    public boolean solution(String s) {
        
        boolean answer = true;

        String numStr = "1234567890";
        
        if(s.length() == 4 || s.length() == 6){
            String[] originStr = s.split("");
            
            for(int i=0; i<s.length(); i++){
                
                if(!numStr.contains(originStr[i])){
                    return false;
                }
            }
        } else{
            return false;
        }
        
        return answer;
    }
}