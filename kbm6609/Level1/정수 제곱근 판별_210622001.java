package Square_Root_Discrimination;

public class SquareRootDiscrimination_210622001 {
    public static void main(String[] args) {
        long n=121;

        long answer;
        double a= Math.sqrt(n);
        if(a-(int)a>0)   answer=-1;
        else answer =(long)((a+1)*(a+1));
        System.out.println(answer);
    }
}
