package Fine_Square;

public class FineSquare_210626001 {
    public static void main(String[] args) {
        int h=1;
        int w=2;

        long answer=(long)w*(long)h;
        if(w==h) answer = answer-(long)w;
        else {
            long x=w,y=h;
            if(w<h){
                x=h;
                y=w;
            }
            double r =y/(double)x;  //기울기
            long lp=0,rp = 0; //y좌표 저장할 변수
            for (long i = 1; i<= x; i++) {
                rp = (long)Math.ceil(i * r);
                lp = (long)Math.floor((i-1) * r);

                answer -= rp - lp;
            }
        }
        System.out.println(answer);

    }
}
