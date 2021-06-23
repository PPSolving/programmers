class Solution {
    public String solution(String s) {
        
        StringBuffer answer = new StringBuffer();
        
        String[] word = s.split(" ");
        
        for(int i=0; i<word.length; i++){

            //공백이 여러개 있을 수도 있으므로
            if(word[i].equals("")){
                answer.append(" ");
                continue;
            }

            String[] strList = word[i].split("");

            for(int j=0; j<strList.length; j++){
                
                if(j%2 == 0){
                    answer.append(strList[j].toUpperCase());
                } else{
                    answer.append(strList[j].toLowerCase());               
                }
            }
            
            if( i != word.length-1){
                answer.append(" ");                
            }
        }
        
        /**마지막 공백 아닐때까지 추가**/
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) != ' '){
                break;
            }
            answer.append(" ");
        }
        
        return answer.toString();
    }
}