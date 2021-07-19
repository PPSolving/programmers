package Large_Number;

public class LargeNumber_210719001 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;


        StringBuilder str = new StringBuilder(number);
        for (int i = 0; i < str.length()&&k!=0; i++) {
            if(i == str.length() - 1 )  str.delete(i + 1 - k, i + 1);
            else if ( str.charAt(i) < str.charAt(i + 1)) {
                str.delete(i, i + 1);
                k--;
                if(i==0) i--;
                else i-=2;
            }
        }
        String answer =str.toString();
        System.out.println(answer);
    }
}
