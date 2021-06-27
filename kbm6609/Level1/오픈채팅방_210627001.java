package Open_Chat_Room;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class OpenChatRoom_210627001 {
    public static void main(String[] args) {
        String[] record ={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        Queue<String[]> re =new LinkedList<>();
        String[] tmp;
        HashMap<String,String> hs =new HashMap<>();
        for(int i=0;i<record.length;i++){
            tmp =record[i].split(" ");
            if(tmp[0].equals("Enter")){
                re.add(new String[]{tmp[0], tmp[1]});
                hs.put(tmp[1],tmp[2]);
            }
            else if(tmp[0].equals("Leave")){
                re.add(new String[]{tmp[0], tmp[1]});
            }
            else {
                hs.put(tmp[1],tmp[2]);
            }
        }
        String[] answer= new String[re.size()];
        for(int i=0;i<answer.length;i++){
            tmp = re.poll();
            if(tmp[0].equals("Enter")){
                answer[i] = hs.get(tmp[1]) + "님이 들어왔습니다.";
            }
            else{
                answer[i] = hs.get(tmp[1]) + "님이 나갔습니다.";
            }
        }
        for(String i :answer) System.out.println(i);
    }
}
