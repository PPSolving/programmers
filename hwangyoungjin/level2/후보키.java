import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int rowSize = relation.length;
        int colSize = relation[0].length;
        
        ArrayList<Integer> list = new ArrayList<>(); //조합된 column
        
        //비트마스킹으로 조합 ex> 0101(=5) 는 학번과 전공 컬럼의 조합
        //(cf. 1<<4이면 10000_(2진) = 16_(10진))
        for(int i=1; i< (1<<colSize); i++){
            //이미 조합에 있으면 check X
            boolean used = false;
            for(int com : list){
                //i의 com이 포함되어 있으면 com
                if((com & i) == com){
                    used = true;
                    break;
                }
            }
            if(used) continue;
            
            //후보키에 포함되지 않은 조합인경우 유일성 확인
            if(check(i,relation,rowSize,colSize)){
                list.add(i);
            }
        }
        return list.size();
    }
    
    //유일하면 true
    public static boolean check(int i, String[][] relation,int rowSize, int colSize){
        //Set으로 유일성 확인
        Set<String> set = new HashSet<>();
        
        //조합된 column index 확인
        ArrayList<Integer> colList = new ArrayList<>();
        for(int col=0; col<colSize; col++){
            if((i&(1<<col)) != 0){//조합된 column의 index인 경우
                colList.add(col);
            }
        }

        //유일성 확인
        for(int row=0; row<rowSize; row++){
            StringBuffer buf = new StringBuffer();
            for(int idx : colList){
                buf.append(relation[row][idx]);
            }
            set.add(buf.toString());
        }
        
        return set.size() == rowSize;
    }
}