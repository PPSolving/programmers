package H_Index;

public class HIndex_210702003 {
    public static void main(String[] args) {
        int[] citations={3, 0, 6, 1, 5};
        int answer = citations.length;
        int a = 0;
        while (true) {
            a=0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=answer) a++;
            }
            if(a==answer&&a>= citations.length-a) break;
            else answer--;
            if(a> citations.length/2) {
                answer = 0;
                break;
            }
        }
        System.out.println(a);

    }
}
