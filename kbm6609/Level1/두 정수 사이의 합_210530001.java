package Sum_Of_Between_Two_Integers;

public class SumOfBetweenTwoIntegers_210530001 {
    public static void main(String[] args) {
        int a=5;
        int b=3;
        long la=a+b;
        long lb=Math.abs(b-a)+1;
        long answer=la*lb/2;
        System.out.println(answer);

    }
}
