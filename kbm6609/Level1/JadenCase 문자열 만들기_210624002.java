package JadenCase_String;

public class JadenCaseString_210624002 {
    public static void main(String[] args) {
        String s="3people unFollowed me";
        char[] tmp =s.toLowerCase().toCharArray();

        boolean ck= true;
        for(int i=0; i<tmp.length;i++){
            if(ck ==true){
                if(tmp[i] >='a'&&tmp[i]<='z'){
                    tmp[i] = (char)(tmp[i]-'a'+'A');
                }
                ck =false;
            }
            if(tmp[i] ==' ') ck =true;
        }
        String answer= new String(tmp);
        System.out.println(answer);
    }
}
