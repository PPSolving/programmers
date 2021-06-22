package Add_Digits;

public class AddDigits_210621005 {
    public static void main(String[] args) {
        int n=123;

        int answer=0;
        for(int i=10;n>0;){
            answer+=n%i;
            n/=i;
        }
        System.out.println(answer);
    }
}
