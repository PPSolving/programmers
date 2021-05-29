package Hate_Same_Number;

import java.util.Stack;

public class HateSameNumber_210529001 {
    public static void main(String[] args) {
        int []arr ={1,1,3,3,0,1,1};
        //이부분은 효율성 테스트에서 실패
//        String str = Arrays.toString(arr);
//        str = str.replaceAll("[^0-9]","");
//        for(String s: new String[]{"11", "22", "33", "44", "55", "66", "77", "88", "99", "00"}){
//            while(str.contains(s)) str =str.replaceAll(s,s.substring(0,1));
//        }
//        int[] answer = new int[str.length()];
//        for(int i=0;i<str.length();i++) answer[i] = str.charAt(i)-'0';

        Stack<Integer> st =new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++) if(st.peek() != arr[i]) st.push(arr[i]);
        int[] answer =new int[st.size()];
        for(int i=st.size()-1;i>=0;i--) answer[i] =st.pop();
        for(int i:answer) System.out.println(i);
    }
}
