package mock_test;

public class mocktest_210519002 {
    public static void main(String[] args) {
        int[] answers= {1,3,2,4,2};
        int[] c ={0,0,0}; // 수포자들의 정답 카운트할변수
        int max =0; //가장 많이 맞은사람 의 정답개수 저장할 변수
        int id=0;
        //수포자들의 답 루틴
        int[] aans= {1,2,3,4,5};
        int[] bans= {2,1,2,3,2,4,2,5};
        int[] cans= {3,3,1,1,2,2,4,4,5,5};
        for(int i=0;i<answers.length;i++){
            if(answers[i] == aans[i%aans.length])   c[0]++;
            if(answers[i] == bans[i%bans.length])   c[1]++;
            if(answers[i] == cans[i%cans.length])   c[2]++;
        }
        for(int i:c) {
            if(max<i) {
                max=i;
                id=0;
            }
            else if(max ==i) id++;
        }
        int[] answer =new int[id+1];
        for(int i = c.length-1; i>=0  ; i--) if(max==c[i]) answer[id--] =i+1;

        for(int i:answer) System.out.println(i+" ");
    }
}

