package Caesar_Password;

public class CaesarPassword_210621002 {
    public static void main(String[] args) {
        String s = "a B z";
        int n =4;

        char[] tmp = s.toCharArray();
        for(int i=0;i<tmp.length;i++){
            if(tmp[i]>='a'&&tmp[i]<='z')
                 tmp[i] = (char)(((tmp[i]-'a') +n)%26+'a');
            else if(tmp[i]>='A'&&tmp[i]<='Z')
                tmp[i] = (char)(((tmp[i]-'A') +n)%26+'A');
        }
        String answer =new String(tmp);
        System.out.println(answer);
    }
}
