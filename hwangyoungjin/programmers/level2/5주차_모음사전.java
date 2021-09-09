import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] chArr = new char[]{'A', 'E', 'I', 'O', 'U'};
        
        ArrayList<String> list = new ArrayList<>();

        //길이 1부터 ~ 5까지 중복순열
        for(int i=1; i<=5; i++){
            permutation(new StringBuffer(), chArr, list,i, 0); 
        }
        
        Collections.sort(list);
        
        return list.indexOf(word)+1;
    }
    //중복 순열
    static public void permutation(StringBuffer buf,
                                   char[] chArr,
                                   ArrayList<String> list,
                                   int selectSize,
                                   int curIdx){
        
        if(curIdx == selectSize){
            list.add(buf.toString());
            buf.delete(buf.length()-1,buf.length()); //마지막 뒤 1개 지우기
            return;
        }
        
        for(int i=0; i<chArr.length; i++){
            buf.append(chArr[i]);
            permutation(buf, chArr, list, selectSize, curIdx+1);
        }

        if(buf.length() != 0) buf.delete(buf.length()-1,buf.length()); //마지막 뒤 1개 지우기
    }
}