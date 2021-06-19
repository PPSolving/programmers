package Place_Descending_Order;

import java.util.Arrays;

public class PlaceDescendingOrder_210531002 {
    public static void main(String[] args) {
        String s = "ZbAcDdefg";

        char[] c= s.toCharArray();
        Arrays.sort(c);
        String answer = new StringBuilder(new String(c)).reverse().toString();
        System.out.println(answer);
    }
}
