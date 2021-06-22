package Turn_Numbers_Upside;

public class TurnNumbersUpside_210621006 {
    public static void main(String[] args) {
        long n = 10000000000L;

        int[] answer =new int[(int)(Math.log10(n)+1)];
        for(int i=0;i<answer.length;i++){
            answer[i] = (int)(n%10);
            System.out.print(answer[i]+" ");
            n/=10;
        }
    }
}
