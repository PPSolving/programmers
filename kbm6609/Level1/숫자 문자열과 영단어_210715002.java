package Numeric_String;

import java.util.HashMap;

public class NumericString_210715002 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        HashMap<String ,Integer> ha =new HashMap<>();
        ha.put("one",1);
        ha.put("two",2);
        ha.put("three",3);
        ha.put("four",4);
        ha.put("five",5);
        ha.put("six",6);
        ha.put("seven",7);
        ha.put("eight",8);
        ha.put("nine",9);
        ha.put("zero",0);

        for (String i : ha.keySet()) {
            s=s.replaceAll(i,String.valueOf(ha.get(i)));
        }
        int answer =Integer.valueOf(s);
        System.out.println(answer);
    }
}
