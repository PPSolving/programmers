package Create_Strange_Characters;

public class CreateStrangeCharacters_210621004 {
    public static void main(String[] args) {
        String s ="TTT TTT SSS TTT SSSSSS TTASD";
        char[] tmp = s.toCharArray();
        int c=0;
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] >='a'&&tmp[i]<='z'){
                if(c%2==0) tmp[i] = (char)(tmp[i]+'A'-'a');
                c++;
            }
            else if(tmp[i] >='A'&&tmp[i]<='Z'){
                if(c%2==1) tmp[i] = (char)(tmp[i]-'A'+'a');
                c++;
            }
            else if(tmp[i]==' ')c=0;
        }
        String answer =new String(tmp);
        System.out.println(answer);
    }
}
