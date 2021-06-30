package Target_Number;

public class TargetNumber_210630002 {
    public static void main(String[] args) {
        int[] numbers={1,2,3,4,5};
        int target=3;
        int answer = run(target,numbers,0,0);
        System.out.println(answer);
    }
    public static int run(int target, int[] numbers,int index,int sum){
        if(numbers.length ==index) {
            if(sum == target) return 1;
            else return 0;
        }
        int q=0;
        q += run(target,numbers,index+1,sum+numbers[index])+ run(target,numbers,index+1,sum-numbers[index]);
        return q;
    }

}
