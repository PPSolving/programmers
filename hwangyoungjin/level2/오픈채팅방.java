import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String,String> name = new HashMap<>();
        int count =0;
        
        //nickname 저장
        for(String s : record){
            String[] strs = s.split(" ");
            if(!strs[0].equals("Leave")){
                name.put(strs[1],strs[2]);            
            }
            if(!strs[0].equals("Change")) count++;
        }
        
        String[] answer = new String[count];
        
        int idx = 0;
        for(String s : record){
            String[] strs = s.split(" ");

            StringBuffer buf = new StringBuffer();
            
            buf.append(name.get(strs[1]));
            
            switch(strs[0]){
                case "Enter":
                    buf.append("님이 들어왔습니다.");
                    answer[idx++] = buf.toString();   
                    break;
                case "Leave":
                    buf.append("님이 나갔습니다.");
                    answer[idx++] = buf.toString();   
                    break; 
            }
        }
        return answer;
    }
}