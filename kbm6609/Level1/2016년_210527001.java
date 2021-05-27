package Year_of_2016;

public class YearOf2016_210527001 {
    public static void main(String[] args) {
        String[] str = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        String answer;
        int a = 5;
        int b = 24;
        int sum =0;
        for(int i=1; i<a;i++) {
            if (((i - 1) % 7) % 2 == 0) sum += 31;
            else {
                if (i == 2) sum += 29;
                else sum += 30;
            }
        }
        sum += b-1;
        answer =str[sum%7];
        System.out.println(answer);
    }
}
