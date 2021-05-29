package Dart_Game;

public class DartGame_210528002 {
    public static void main(String[] args) {
        String dartResult="1D2S3T*";



        int current = 0;
        int pre = 0;
        int answer = 0;
        int n1=1,n2=0;
        for(int i=0;i<dartResult.length();i++){
            char tmp =dartResult.charAt(i);
            if(tmp>='0'&&tmp<='9'){
                if(n2>0) current *=-1;
                answer += pre * n1;

                pre = current *n1;
                current =tmp - '0';
                if(tmp =='1' &&dartResult.charAt(i+1)=='0') {
                    current =10;
                    i++;
                }
                n1=1;
                n2=0;
            }
            else{
                switch (tmp){
                    case 'D':
                        current *= current;
                        break;
                    case 'T':
                        current *= current * current;
                        break;
                    case '*':
                        n1 *= 2;
                        break;
                    case '#':
                        n2++;
                }
            }
        }
        answer += pre * n1;
        if(n2>0) current *=-1;
        answer += current * n1;
        System.out.println(answer);

    }
}
