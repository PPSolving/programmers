package Remove_Smallest_Number;


public class RemoveSmallestNumber_210622002 {
    public static void main(String[] args) {
        int[] arr ={10,15,5415,1646,101,1,2};
        int[] answer ;
        if(arr.length==1) answer = new int[]{-1};
        else{
            int min =arr[0];
            int j=0;
            answer =new int[arr.length-1];
            for(int i:arr){
                if(min>i) min =i;
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=min) answer[j++] =arr[i];
           }
        }
        for(int i:answer)
        System.out.println(i);

    }
}
