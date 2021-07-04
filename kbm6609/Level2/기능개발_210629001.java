package Function_Development;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelopment_210629001 {
    public static void main(String[] args) {
        int[] progresses={95, 90, 99, 99, 80, 99};
        int[] speeds={1, 1, 1, 1, 1, 1};
        List<Integer> arr =new ArrayList<>();
        int index=0;
        int c=0;
        while(index <progresses.length){
        for(int i=index; i<progresses.length;i++){
            progresses[i] +=speeds[i];
        }
        c=0;
        while(index<progresses.length&&progresses[index]>=100){
            index ++;
            c++;
        }
        if(c>0) arr.add(c);
        }
        int[] answer =new int[arr.size()];
        for(int i=0;i<answer.length;i++) answer[i] =arr.get(i);
        for(int i:answer) System.out.println(i);
    }
}
