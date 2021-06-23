package Collatz__Quess;

public class CollatzQuess_210623002 {
    public static void main(String[] args) {
        int num=626331;
        int answer=0;
        long tmp=num;
        while(tmp!=1 && answer !=-1){
            if(tmp%2 ==0) tmp/=2;
            else tmp= tmp * 3 +1;
            answer++;
            if(answer >=500) answer = -1;
        }
        System.out.println(tmp);
        System.out.println(answer);


    }
}
