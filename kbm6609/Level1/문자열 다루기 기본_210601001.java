package String_Handling_Default;

public class StringHandlingDefault_210601001 {
    public static void main(String[] args) {
        String  s= "1234a";
        boolean answer =s.replaceAll("[0-9]","").length()==0&&(s.length() ==4||s.length()==6);
        System.out.println(answer);
    }
}
