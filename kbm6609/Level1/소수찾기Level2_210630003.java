package Find_Decimal_Level2;

import java.util.HashMap;

public class FindDecimalLevel2_210630003 {
    public static void main(String[] args) {
        String numbers="011";
        int answer =0;

        HashMap<Integer,Integer> hs =new HashMap<>();
        char[] tmp =numbers.toCharArray();
        boolean[] check =new boolean[tmp.length];
        for(int k=1;k<=tmp.length;k++){
            answer +=run(tmp,0,check,0,k,hs);
        }
        System.out.println(answer);

    }
    static int run(char[] numbers,int index,boolean[] check,int sum,int le,HashMap<Integer,Integer> hs){
        int c=0;
        int num=sum;
        if(index>=le&&!hs.containsKey(sum)) {
            hs.put(sum,1);
            System.out.println(sum);
            if(findeci(sum))return 1;
            else return 0;
        }

        for(int i=0;i<numbers.length;i++){
            if(!check[i]){
                check[i] =true;
                sum = num*10+(int)(numbers[i]-'0');
                c += run(numbers,index+1,check,sum,le,hs);
                check[i] =false;
            }
        }
        return c;
    }

    static boolean findeci(int n) {
        int c=0;
        for (int i = 1; i <= n; i++) if(n%i==0) c++;
        if(c==2) return true;
        else return false;

    }
}
