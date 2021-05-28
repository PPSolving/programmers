package Number_and_Addition_of_MineralNumbers;

public class NumberAndAdditionOfMineralNumbers_210525001 {
    public static void main(String[] args) {
        int left,right;
        left =13;
        right =17;
        int answer=0;

        for(int i =left ; i<=right;i++) answer += mn(i);
        System.out.println(answer);
    }

    public static int mn(int n){
        int num =0;
        for(int i=1;i<=n;i++) if(n%i==0) num++;
        if(num%2==0) return n;
        return n*(-1);
    }
}

