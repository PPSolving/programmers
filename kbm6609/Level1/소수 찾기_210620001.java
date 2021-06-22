package Find_decimal;

public class Finddecimal_210621 {
    public static void main(String[] args) {
        int n=10;
        int answer=0;
        int j;
        int arr[] = new int[n+1];
        for(int i=2;i<=n;i++){
            if(arr[i]==0){
                answer++;
                j=1;
                while(i*j <=n){
                    arr[i*j]=1;
                    j++;
                }
            }
        }
        System.out.println(answer);
    }
}
