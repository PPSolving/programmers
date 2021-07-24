package Binary_Transformation;

public class BinaryTransformation_210721002 {
    public static void main(String[] args) {
        String s = "110010101001";
        int[] answer =new int[2];
        int a,b;
        while(s.length()!=1){
            answer[0]++;
            a=s.length();
            s = s.replaceAll("0", "");
            b=s.length();
            answer[1] += a-b;
            s = Integer.toBinaryString(b);
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
