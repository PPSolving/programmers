import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //학생 수 n
        //도난당한 학생의 번호 lost
        //여벌옷이 있는 학생의 번호 reserve
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList<Integer> lostNumber = new ArrayList<>();
        ArrayList<Integer> lostTmp = new ArrayList<>();
        ArrayList<Integer> reserveNumber = new ArrayList<>();
        
        
        //list로 변환
        for(int i=0; i<lost.length; i++){
            lostNumber.add(lost[i]);
            lostTmp.add(lost[i]);
        }

        for(int i=0; i<reserve.length; i++){
            reserveNumber.add(reserve[i]);
        }
        
        int remove =0;
        
        for(Integer lo : lostTmp){
            
            if(reserveNumber.contains(lo)){
                //자신꺼 제거하고 remove꺼 제거
                lostNumber.remove(lo);
                reserveNumber.remove(lo);
                continue;
            }
        }
        
        //여벌 체육복을 가져온 사람이 중간에 도난 당할 수 있으므로
        for(Integer lo : lostNumber){
            
            int count = reserveNumber.size();

            //첫 번째 학생에 대해서
            for(int j=0; j<count; j++){
            
                Integer re = reserveNumber.get(j);
                
                //빌려줄 수 있는 학생이 있는지 검사
                if((lo - 1 == re || lo + 1 == re)){
                    reserveNumber.remove(re);
                    remove ++;
                    break;
                }
            }
        }

        int answer = n-lostNumber.size()+remove;
        
        return answer;
    }
}