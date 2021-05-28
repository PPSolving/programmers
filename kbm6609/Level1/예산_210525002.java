package Budget;

import java.util.Arrays;

public class Budget_210525002 {
    public static void main(String[] args) {
        int[] d={1,3,2,5,4};
        int budget=9;

        int answer = 0;
        Arrays.sort(d);
        for(int i :d){
            budget-=i;
            if(budget<0)break;
            else answer++;
        }
        System.out.println(answer);


    }
}
