import java.util.*;

class Stage implements Comparable<Stage>{
    int stageNum;
    double faliRate;
    Stage(int stageNum , double faliRate){
        this.stageNum = stageNum;
        this.faliRate = faliRate;
    }
    public int compareTo(Stage o){
        if(this.faliRate == o.faliRate){
            return this.stageNum - o.stageNum; 
        }
        return this.faliRate > o.faliRate ? -1 : 1;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        //실패율
        ArrayList<Stage> stageList = new ArrayList<>();
        
        //단계별 참여인원수
        int[] numbers = new int[N+1];
        
        for(int i=0; i<stages.length; i++){
            numbers[stages[i]-1] += 1; 
        }
        
        //총 참여인원
        int par = stages.length;
        
        //각 단계까지 참여한 총 인원
        int[] totalNum = new int[N+1];
        for(int i=0; i<numbers.length-1; i++){
            totalNum[i] = stages.length;
            for(int j=i-1; j>=0; j--){
                totalNum[i] -= numbers[j];
            }
            if(totalNum[i] == 0){ //마지막 단계에 아무도 못한 경우 0이 될 수 있다. 
                stageList.add(new Stage(i+1,0));
            } else{
                stageList.add(new Stage(i+1,((double)numbers[i]/(double)totalNum[i])));            
            }
        }
        
        Collections.sort(stageList);
        
        int i=0;
        int[] answer = new int[N];
        
        for(Stage s : stageList){
            answer[i++] = s.stageNum;
        }

        return answer;
    }
}