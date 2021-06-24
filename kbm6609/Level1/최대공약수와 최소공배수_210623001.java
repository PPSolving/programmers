package Max_Of_Pledges_And_Min_Multiple;

public class MaxOfPledgesAndMinMultiple_210623001 {
    public static void main(String[] args) {
        int n=24;
        int m=51;
        int max ,min;
        int[] answer= new int[2];
        if(n<m) {
            max =m;
            min =n;
        }
        else {
            max = n;
            min = m;
        }
        for(int i=1; i<=min;i++){
            if(min%i==0){
                if(max%(min/i)==0){
                    answer[0] =min/i;
                    break;
                }
            }
        }
        for(int i = max ; ; i++){
            if(i%m ==0 && i%n ==0) {
                answer[1] = i;
                break;
            }
        }
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
