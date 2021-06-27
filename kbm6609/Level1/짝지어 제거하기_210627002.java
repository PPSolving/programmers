package Pair_Remove;

import java.util.Stack;

public class PairRemove_210627002 {
    public static void main(String[] args) {
        String s ="baabaa";


        //스트링빌더로 하는것은 시간초과
      /*
      StringBuilder str =new StringBuilder(s);
        int i = 0;
        int a=0;
        int answer=0;
        if(s.length()%2==0) {
            char[] tmp = s.toCharArray();
            while (i < str.length() - 1) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    a=0;
                    while(i-a>0&&i+a<str.length()-1&&str.charAt(i-a-1) == str.charAt(i + a+2)){
                        a++;
                    }
                    str.delete(i - a, i + a + 2);
                    if (i != 0) i-=a;
                } else i++;
            }

            if (str.length() == 0) answer = 1;
        }*/
        //스텍 사용 (성공) 테스트 상에선 둘이 5~10ms 차이밖에안낫엇는데 효율성테스트(양이 많은 경우) 엔 차이가 심한거같다.
        Stack<Character> st =new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(st.empty()||st.peek() != arr[i]) st.push(arr[i]);
            else{
                st.pop();
            }
        }
        int answer=0;
        if(st.size()==0)answer =1;
        System.out.println(answer);
    }
}
