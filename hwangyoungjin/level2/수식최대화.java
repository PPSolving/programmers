import java.util.*;
class Solution {
    public long solution(String expression) {
        
        LinkedList<Long> nums = new LinkedList<>(); //숫자
        LinkedList<Character> chars = new LinkedList<>(); //연산문자
        Map<Character,Integer> charMap = new HashMap<>(); //연산 종류 저장

        //숫자와 연산문자 구분
        StringBuffer buf = new StringBuffer(); 
        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch >= '0' && ch <='9'){
                buf.append(ch);
                if(i== expression.length()-1) nums.add(Long.parseLong(buf.toString()));

            } else{
                nums.add(Long.parseLong(buf.toString()));
                buf.delete(0,buf.length());
                chars.add(ch);
                charMap.put(ch,charMap.getOrDefault(ch,0)+1);
            }
        }
        
        //연산문자 종류개수 구하기
        Set<Character> cSet = charMap.keySet();
        char[] caseNum = new char[cSet.size()];

        int k = 0; //index
        for(char c : cSet){
            caseNum[k++] = c;
        }
        
        //최종 결과 담을 데이터
        LinkedList<Long> result = new LinkedList<>();
        
        //permutation 연산
        boolean[] used = new boolean[cSet.size()];        
        compute(result,chars,nums,0,caseNum,used);
        
        Collections.sort(result);
        
        long answer = result.getLast();
        return answer;
    }
    
    public static void compute(LinkedList<Long> result
                              ,LinkedList<Character> chars
                              ,LinkedList<Long> nums
                              ,int idx
                              ,char[] caseNum
                              ,boolean[] used){
        
        if(idx == caseNum.length){
            long newNum = Math.abs(nums.getFirst());
            result.add(newNum); //정한 우선순위에 대한 최종결과
            return;
        }
        
        LinkedList<Character> temChars = chars;
        LinkedList<Long> temNums = nums;
        
        for(int i=0; i<caseNum.length; i++){
            
            //새로운 우선순위마다 기존 배열로 다시 permutation
            temChars = new LinkedList<>(chars);
            temNums = new LinkedList<>(nums);
            
            if(!used[i]){
                
                used[i] = true;
                
                char ch = caseNum[i];
                int j =0;
                
                while(j < temChars.size()){
                 //ch연산 모두 수행
                    long num = 0;
                    long first = temNums.get(j);
                    long second = temNums.get(j+1);
                    char char1 = temChars.get(j);
                    if(ch == char1){
                        switch(ch){
                            case '+':
                                num = (first+second);
                                break;
                            case '-':
                                num = (first-second);
                                break;
                            case '*':
                                num = (first*second);
                                break;
                        }
                        //연산 할 것 이므로 제거
                        temChars.remove(j);
                        temNums.remove(j);
                        temNums.remove(j); //j+1 위치의 있던 값 
                        
                        //j위치에 연산 결과 넣기
                        temNums.add(j, num);
                        
                    }else{
                        j++; //다음연산으로  
                    }
                       
                }//end while
                compute(result,temChars,temNums,idx+1,caseNum,used);
                used[i] = false;
            }// end if
        }// end for
        return;
    }
}