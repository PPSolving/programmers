package Sum_of_Mineral_Numbers;

public class SumofMineralNumbers_210621003 {
    public static void main(String[] args) {
        int n=12;

        int sum=0;
        for(int i=1;i<=n;i++){
            if(n%i==0) sum+=i;
        }
        System.out.println(sum);
    }
}
