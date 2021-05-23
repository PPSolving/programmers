package Press_keypad;

public class Presskeypad_210523002 {
    public static void main(String[] args) {
        int[] numbers={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand="right";
        String answer = "";
        int r = 12;
        int l = 10;
        for(int i:numbers){
            if(i==0) i=11;
            if(i%3==1){
                answer+="L";
                l = i;
            }
            else if(i%3 ==0){
                answer+="R";
                r = i;
            }
            else {
                int rlt=Math.abs((r-1)%3-(i-1)%3)+Math.abs((r-1)/3-(i-1)/3);
                int llt = Math.abs((l-1)%3-(i-1)%3)+Math.abs((l-1)/3-(i-1)/3);
                if(rlt <llt || (rlt==llt&&hand.equals("right")))
                {
                    answer+="R";
                    r = i;
                }
                else{
                    answer+="L";
                    l = i;
                }


            }
        }
        System.out.println(answer);
    }
}
