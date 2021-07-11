import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<String> dictionary = new ArrayList<>(); 
        ArrayList<Integer> result = new ArrayList<>(); 
        dictionary.add("0");
        for(int i = 'A'; i<='Z'; i++){
            char ch = (char) i;
            dictionary.add(ch+"");    
        }
      
        StringBuffer buf = new StringBuffer();
        int index = 0;
        while(index < msg.length()){
            
            buf.append(msg.charAt(index));
            
            if(index == msg.length()-1) break;
    
            boolean finish = false;
            while(dictionary.contains(buf.toString())){
                if(index+1 == msg.length()){
                    //마지막까지 포함된 단어라면
                    finish = true;
                    break;
                }
                index++;
                buf.append(msg.charAt(index));
            }
            
            if(finish) break;
            
            if(buf.length() != 0){
                //buf에 담겨 있고 사전에 없는경우
                //이전까진 포함하므로 
                result.add(dictionary.indexOf(buf.substring(0,buf.length()-1)));
                //현재까지단어 저장
                dictionary.add(buf.toString());
                //전체제거
                buf.delete(0,buf.length());                        
            }
        }
        
        if(buf.length()>0){
            result.add(dictionary.indexOf(buf.toString()));
        }
        
        answer = new int[result.size()];
        int idx =0;
        for(int i : result){
            answer[idx++] = i;
        }
        return answer;
    }
}