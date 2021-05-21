package add_yandy;

public class addyandy_210520001 {
    public static void main(String[] args) {
        int[] absolutes={4,7,12};
        boolean[] signs={true,false,true};
        int answer =0;
        for(int i=0;i<absolutes.length;i++) answer +=absolutes[i] * (signs[i]?1:-1);

        System.out.println(answer);
    }
}
