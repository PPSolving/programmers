package Group_Photo;

import java.util.HashMap;
import java.util.Stack;

class condition{
    HashMap<Character,Integer> use =new HashMap<>();// 조건에 속하는 사람을 표시해주는 해쉬맵
    HashMap<Integer,Integer> condi =new HashMap<>();// 조건을 최종 2진수로 만든 해쉬맵

    HashMap<Integer,Character> a =new HashMap<>(); //이 두개는 배열대신 사용되는 해쉬맵
    HashMap<Character,Integer> b =new HashMap<>();



    Stack<String> con =new Stack<>();
    String t =new String();
    void inputcon(String str){
        use.put(str.charAt(0),1);
        use.put(str.charAt(2),1);
        con.push(str);
    }
    void creatcon(){
        while(!con.empty())
        t = con.pop();
        if(t.charAt(3)=='='){

        }
        else if(t.charAt(3)=='<'){

        }
        else if(t.charAt(3)=='>'){

        }
    }

}
public class GroupPhoto_210625001 {
    public static void main(String[] args) {

    }

}
