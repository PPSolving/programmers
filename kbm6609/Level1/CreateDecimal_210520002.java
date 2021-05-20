package Create_Decimal;

import java.util.Arrays;

public class CreateDecimal_210520002 {
    public static void main(String[] args) {
        int[] num =new int[50];
        for(int i=0;i<num.length;i++) num[i] =i;
        int id=0;
        int count =0;
        Arrays.sort(num);
        for(int i=0;i<3;i++) id += num[num.length-1-i];

        boolean[] check = new boolean[id+1];
        System.out.println(check.length);

        for(int i=2;i<check.length;i++){
            if(check[i]==false) {//false 인것들은 소수인것이므로 소수의 배수들을 true로 배제시킴
                for (int j = 2; j * i < check.length; j++) check[j*i] = true;
            }
        }
        for(int i=0;i< num.length-2;i++)
            for(int j=i+1;j< num.length-1;j++)
                for(int k=j+1;k< num.length;k++)
                    if(check[num[i]+num[j]+num[k]]==false) {
                        count++;
                    }
        System.out.println(count);
    }
}
