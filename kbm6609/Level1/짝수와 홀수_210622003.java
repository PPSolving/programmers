package Even_And_Odd;

public class EvenAndOdd_210622003 {
    public static void main(String[] args) {
        int num =-2;
        num  =Math.abs(num);
        String answer ="";
        if(num%2==1) answer ="Odd";
        else answer ="Even";
        System.out.println(num%2);
        System.out.println(answer);
    }
}
