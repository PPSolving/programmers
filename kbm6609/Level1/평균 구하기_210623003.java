package Get_Average;

public class GetAverage_210623003 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        double sum = 0;

        for(int i:arr) sum+=i;
        sum/=arr.length;
        System.out.println(sum);
    }
}
