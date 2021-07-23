package Two_Different_Bits;

public class TwoDifferentBits_210723002 {
    public static void main(String[] args) {
        long[] numbers={15,7};
       long[] answer= new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int t=-1;
            long num=numbers[i];
            while (num!=0) {
                if(num%2==0)  break;
                t++;
                num/=2;
            }
            answer[i] =numbers[i]+(long)Math.pow(2,t==-1?0:t);
        }
        /*     long[] answer = numbers.clone();
        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            long a=answer[i]^numbers[i];
            long b= a>>>2;
            answer[i] += b;
           *//*  2^0 부터 처음으로 0이 나오는 지점 직전의 비트를 1증가 시켜주는게 서로 다른비트가 2개 이하인 값들중 가장 작은
             값을 갖는다 즉 1을 증가시켜줄 값을 찾으면 된다
             이때 +1 시키면 1이 시작 기준으로 1이 연속되는 개수만큼 의 비트들이 원래 비트와 다른 비트를 갖는다
            즉 1을 더해준것과 원래 수를 Exclusive or 을 시켜주면 처음으로 0이 등장하는 부분까지의 비트들이 전부 1인
            값이 나오는데 이때 가장큰 값 바로이전비트를 더해줘야하므로 right shift 1을 해줘야하고 이미 1을 더해줫으므로 한번더
            shyft를 해주면 된다*//*
        }*/
        for(long i: answer) System.out.println("i = " + i);
    }
}
