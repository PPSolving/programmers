import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        //집합 저장
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int idx = 0; 
        int count = 0;
        StringBuffer buf = new StringBuffer();
        int setCount = 0; //집합 개수-1
        
        //맨처음 수 넣기
        list.add(new ArrayList<Integer>());
        
        while(idx < s.length()){
                
            char ch = s.charAt(idx);
            
            switch (ch){
                case '{':
                    count ++;
                    break;
                case '}':
                    if (count == 2){ //2일때 집합 안 다른수
                        list.get(setCount).add(Integer.parseInt(buf.toString()));
                        buf.delete(0,buf.length());
                    }
                    count --;
                    break;
                case ',':
                    if(count == 1){ //1일때 다른 집합으로 넘어감
                        list.add(new ArrayList<Integer>());
                        setCount++;
                    } else if (count == 2){ //2일때 집합 안 다른수
                        list.get(setCount).add(Integer.parseInt(buf.toString()));
                        buf.delete(0,buf.length());
                    }
                    break;
                default :
                    buf.append(ch);
                    break;
            }
            
            idx++;
        }
        
        //size 오름차순 정렬
        Collections.sort(list,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                return o1.size()-o2.size();
            }
            
        });
        
        //튜플 저장할 list
        ArrayList<Integer> result = list.get(0);
        
        for(int i=1; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++){
                int num = list.get(i).get(j);
                if(!result.contains(num)){
                    result.add(num);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        int index = 0;
        for(int su : result){
            answer[index++] = su;
        }
        return answer;
    }
}