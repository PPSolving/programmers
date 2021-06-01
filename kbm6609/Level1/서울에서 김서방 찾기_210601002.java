package Finding_Kim_In_Seoul;

import java.util.ArrayList;
import java.util.Arrays;

public class FindingKimInSeoul_210601002 {
    public static void main(String[] args) {
        String[] seoul={"Jane", "Kim"};
//        ArrayList<String> al = new ArrayList<>(Arrays.asList(seoul));
//        String answer ="김서방은 "+al.indexOf("Kim")+"에 있다";
//        indexOf 안에서 for문을 도는거라 굳이 ArraysList 로 할필요 없다 오히려 공간적 손해이다

        //실제로 실행시간은 둘이 비슷 단 import 필요가 없다
       int i;
        for(i=0;i<seoul.length;i++) if(seoul[i].equals("Kim")) break;
        String answer ="김서방은 "+i+"에 있다";
        System.out.println(answer);

    }
}
