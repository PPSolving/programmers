package Lifeboat;

import java.util.Arrays;

public class Lifeboat_210714002 {
    public static void main(String[] args) {
        int[] people={70, 50,60, 80,60};
        int limit =100;


        int answer = 0;
        Arrays.sort(people);
        int end = people.length - 1;
        int i;
        for(i=0;i<people.length;i++){
            if(people[i] +people[i+1] >limit || i>end) break;
            if(i==end||people[i] +people[end] >limit) i--;
            answer++;
            end --;
        }
        answer += end - i +1;
    }
}
