package N_Minimum_Common_Multiple;

public class NMinimumCommonMultiple_210624001 {
    public static void main(String[] args) {
        int[] arr ={2,6,8,14};

        int answer =1;
        for(int i=0;i<arr.length;i++){
            for(int j=2;j<=arr[i];j++){
                if(arr[i]%j==0){
                    answer*=j;
                    for(int k=i;k<arr.length;k++){
                        if(arr[k]%j==0) arr[k]/=j;
                    }
                    j--;
                }
            }
        }
        System.out.println(answer);
    }
}
