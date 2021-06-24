package Number_of_Hashards;

public class NumberofHashards_210623004 {
    public static void main(String[] args) {
        int x =10;
        boolean answer=false;

        int sum =0;

        for(int i=1;i<=x;i*=10) sum += (x/i)%10;
        if(x%sum ==0) answer =true;
    }
}
