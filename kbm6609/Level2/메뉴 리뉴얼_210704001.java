package Menu_Renewal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class MenuRenewal_210704001 {
    public static void main(String[] args){
        String[] orders= {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course={2,3,4};
        HashMap<String ,Integer> hs =new HashMap<>();
        Stack<Character> st =new Stack<>();

        for(int i=0;i< orders.length-1;i++){
            char[] tmp = orders[i].toCharArray();
            for(int j= i+1;j< orders.length;j++){
                for(char k:tmp){
                    if(orders[j].contains(String.valueOf(k))) st.push(k);
                }
                if (st.size() >= course[0]) {
                    char[] arr = new char[st.size()];
                    for (int k = 0; k < arr.length; k++) arr[k] = st.pop();
                    Arrays.sort(arr);
                    for (int m = 0; m < course.length; m++) {
                        run(hs,0,-1,new char[course[m]],arr);
                    }
                }
                else st.clear();
            }
        }
        Stack<String> re = new Stack<>();
        Stack<String> re1 = new Stack<>();

        for(int i=0;i<course.length;i++){
            int max =0;
            for(String j : hs.keySet()){
                if(j.length() == course[i] ){
                    if( max ==hs.get(j)) {
                        re.push(j);
                    } else if (max < hs.get(j)) {
                        max = hs.get(j);
                        re.clear();
                        re.push(j);
                    }

                }
            }
            while(!re.isEmpty()) re1.add(re.pop());
        }
        String[] answer=new String[re1.size()];
        for(int j =0;!re1.isEmpty();j++)
            answer[j] =re1.pop();
        Arrays.sort(answer);

    }
    static void run(HashMap<String ,Integer> hs,int index ,int i,char[] q,char[] arr){
        if(index ==q.length){
            String w =new String(q);
            hs.put(w, hs.getOrDefault(w,0)+1);
            return ;
        }

        for (int j = i + 1; j < arr.length - q.length + index + 1; j++) {
            q[index] =arr[j];
            run(hs,index+1,j,q,arr);
        }
    }

}


