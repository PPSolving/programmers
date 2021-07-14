package Next_large_number;

public class Nextlargenumber_210714001 {
    public static void main(String[] args) {
        int n = 1;

        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n));
        binary.reverse();
        int start =binary.indexOf("1");
        int end ;
        for(end=start+1;end<binary.length();end++)  if(binary.charAt(end)=='0') break;
        int answer = n + (int) (Math.pow(2, start) + Math.pow(2, end - start - 1) - 1);




        // System.out.println("binary = " + binary);
        //System.out.println("start = " + start);
        // System.out.println("end = " + end);
        //  System.out.println(answer);



    }
}
