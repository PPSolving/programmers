package Ttangttameokgi;


import java.util.*;

public class Ttangttameokgi_210710001 {
    public static void main(String[] args) {
        int[][] land={{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int[] psum =new int[]{0,0,0,0};
        int[] sum =new int[4];
        for(int j=0;j<4;j++){
            sum[j]=land[0][j];
        }
        for (int i = 1; i < land.length; i++) {
            for(int j=0;j<4;j++){
                psum[j]=sum[j];
            }
            sum[0] =Math.max(land[i][0]+psum[1],Math.max(land[i][0]+psum[2],land[i][0]+psum[3]));
            sum[1] =Math.max(land[i][1]+psum[1],Math.max(land[i][1]+psum[2],land[i][1]+psum[3]));
            sum[2] =Math.max(land[i][2]+psum[1],Math.max(land[i][2]+psum[2],land[i][2]+psum[3]));
            sum[3] =Math.max(land[i][3]+psum[1],Math.max(land[i][3]+psum[2],land[i][3]+psum[3]));
        }
        int answer = Math.max(sum[1],Math.max(sum[2],sum[3]));
        System.out.println(answer);

    }

}
