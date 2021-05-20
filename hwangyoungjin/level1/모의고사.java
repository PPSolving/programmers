import java.util.*;

class Num implements Comparable<Num> {
    int name;
    int value;
    
    Num(int n, int v){
         this.name=n;
         this.value=v;
    }
    
    public int compareTo(Num o){
        return this.value - o.value;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        
        //1번은 1~5 순서대로
        
        //2번은 짝수는 2, 홀수는 1,3,4,5 순서대로 4개씩 반복
    
        //3번은 2개씩 3->1->2->4->5 
        // oddC ex> 3번째 13번째 .... 은 모두 답 1 이고 (13%4) = 3이 되어 인덱스 3의 답인 1을 넣는다
        int[] oddC = new int[]{2,3,4,1,5};
        int[] evenC = new int[]{3,4,1,5,2};
        
        List<Num> list = new ArrayList<>();
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=0; i<answers.length; i++){
            // i 는 문제 번호
            if(answers[i] == (i%5+1)){ //ex> amswer[6]의 답 == (6%5 +1 = 2) 이면 A 정답
                a++;
            }
            
            if( ((i%2==0) && answers[i] == 2) //짝수번째 답이 2이면  
                || ((((i/4)%2) == 0) && (i%4 == 1) && (answers[i] == 1)) // ((i/4)%2)가 짝수 이고 (i%4) == 1이고 1번답이면
                || ((((i/4)%2) == 0) && (i%4 == 3) && (answers[i] == 3)) // ((i/4)%2)가 짝수 이고 (i%4) == 3이고 3번답이면
               || ((((i/4)%2) == 1) && (i%4 == 1) && (answers[i] == 4)) // ((i/4)%2)가 홀수 이고 (i%4) == 1이고 4번답이면
               || ((((i/4)%2) == 1) && (i%4 == 3) && (answers[i] == 5)) ){ // ((i/4)%2)가 홀수 이고 (i%4) == 3이고 5번답이면
                b++;
            }
            if(((i%2 == 1) && (answers[i] == oddC[i%5])) //홀수번의 정답이 oddC[i%5]와 같거나
                || (((i%2 == 0) && (answers[i] == evenC[i%5])))){ //짝수번의 정답이 even[i%5]와 같으면 C정답
                c++;
            }
        }
        
        list.add(new Num(1,a));
        list.add(new Num(2,b));
        list.add(new Num(3,c));
        
        //오름차순
        Collections.sort(list);
        
        int[] answer = {};
        
        if(list.get(0).value == list.get(1).value 
           && list.get(0).value == list.get(2).value){
            answer = new int[]{1,2,3};
        } else if(list.get(2).value == list.get(1).value){
            if(list.get(2).name < list.get(1).name){
                answer = new int[]{list.get(2).name,list.get(1).name};            
            } else{
                answer = new int[]{list.get(1).name, list.get(2).name};
            }
        } else {
            answer = new int[]{list.get(2).name};
        }

        
        return answer;
    }
}