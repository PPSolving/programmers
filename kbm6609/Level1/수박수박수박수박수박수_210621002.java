package WatermelonWatermelon;

public class WatermelonWatermelon_210621002 {
    public static void main(String[] args) {
        int n=3;
        char[] tmp =new char[n];
        String answer;
        for(int i=0;i<n;i++){
            if(i%2==0) tmp[i]='수';
            else tmp[i] ='박';
        }
        answer =new String(tmp);
        System.out.println(answer);
    }
}
