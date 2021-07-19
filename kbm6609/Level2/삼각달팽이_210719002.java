package Triangle_Snail;

public class TriangleSnail_210719002 {
    public static void main(String[] args) {
        int n = 6;
        int[] answer= new int[((n+1)*n)/2];
        int index = 0;
        int move =-1;  // -1 은 왼쪽아래 0은 오른쪽 1 은 윈쪽위
        int floor=1;
        for(int i=1;i<=answer.length;i++){
            answer[index] = i;
            if (move == -1) {
                if(index+floor <answer.length &&answer[index+floor]==0){
                    index+=floor;
                    floor++;
                }else{
                    move =0;
                    index++;
                }
            } else if (move == 0) {
                if(index+1 <answer.length &&answer[index+1]==0){
                    index++;
                }else{
                    move =1;
                    index-=floor;
                    floor--;
                }
            }else {
                if(answer[index-floor]==0){
                    index-=floor;
                    floor--;
                }else{
                    move =-1;
                    index+=floor;
                    floor++;
                }
            }
        }
        for (int i : answer) {
            System.out.print(i+" ");
        }
    }

}
