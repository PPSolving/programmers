package Phone_Number_List;

import java.util.HashMap;

public class PhoneNumberList_210705001 {
    public static void main(String[] args) {
        String[] phone_book={"12","123","1235","567","88"};
        boolean answer = true;
        HashMap<String ,Integer> hs =new HashMap<>();
        HashMap<Integer ,Integer> len =new HashMap<>();
        for(String i :phone_book) {
            for(int j:len.keySet()){
                if(i.length() >=j &&hs.getOrDefault(i.substring(0,j),0)!=0){
                    answer =false;
                    break;
                }
            }
            if(!answer)break;
            hs.put(i,1);
            len.put(i.length(),1);
        }
        System.out.println(answer);





    }
}
