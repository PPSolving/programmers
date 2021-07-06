package Joystick;

public class Joystick_210705002 {
    public static void main(String[] args) {
        String name="JAN";
        int answer= 0;
        int nlen =name.length();
        boolean[] len=new boolean[nlen];
         for(int i=0;i<nlen;i++) {
             if(name.charAt(i)!='A') len[i] = true;
             if ((name.charAt(i) - 'A' + 1) <= 13) answer += name.charAt(i) - 'A';
             else answer += 26 - name.charAt(i) + 'A';
         }
        int r=0, l=0;  //현재 인덱스 기준 좌측우측으로 가야할 거리 저장할 변수
        int p = 0; // 현재 위치한 인덱스
        boolean flag =true;
        for(int i=0;i<len.length;i++) {
            len[p] =false;
            for (int j =( p + 1)%nlen; flag; j = (j+1)%nlen) {
                if (len[j]) {
                    r=j;
                    break;
                }
                if(j==p) flag =false;
            }
            if(!flag) break;
            for (int j = (nlen - 1 + p)%nlen; ; j = (nlen + j - 1) % nlen) {
                if (len[j]) {
                    l = j;
                    break;
                }
            }
            if ((nlen + r - p) % nlen > (nlen + p - l) % nlen) {
                answer += (nlen + p - l) % nlen;
                p =l;
            } else {
                answer += (nlen + r - p) % nlen;
                p = r;
            }
        }
        System.out.println(answer);
    }
}
