package Covering_Phone_Number;

public class CoveringPhoneNumber_210623005 {
    public static void main(String[] args) {
        String phone_number="01033334444";
        String answer;

        answer = "*".repeat(phone_number.length()-4)+phone_number.substring(phone_number.length()-4);
        System.out.println(answer);

    }
}
