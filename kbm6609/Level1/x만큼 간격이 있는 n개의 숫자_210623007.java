package n_numbers_spaced_by_x;

public class NNumbersSpacedByX_210623007 {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        long[] answer=new long[n];
        for(int i=0;i<n;i++){
            answer[i] = x+(long)i*x;
        }
        for(long i:answer) System.out.println(i);
    }
}
