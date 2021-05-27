package Import_Middle_Letter;

public class ImportMiddleLetter_210527002 {
    public static void main(String[] args) {
        String s= "qwer";
        int midnum = s.length()/2;
        String answer ;
        if(s.length()%2 ==0) answer = s.substring(midnum-1,midnum+1);
        else answer = s.substring(midnum,midnum+1);
        System.out.println(answer);
    }
}
