package Number_Of_124_Countries;

public class NumberOf124Countries_210628001 {
    public static void main(String[] args) {
        int n=10;
        int a;
        StringBuilder tmp = new StringBuilder();
       while(true){
           a = n % 3;
           n /= 3;
           if(a==0){
               a=4;
               n--;
           }
           tmp.append(a);
           if(n<3){
               if(n!=0) tmp.append(n);
               break;
           }
       }
        String answer =new String(tmp.reverse());
       System.out.println(answer);

    }
}
