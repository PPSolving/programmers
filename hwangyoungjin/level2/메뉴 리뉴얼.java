import java.util.*;


class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        //orders 목록의 알파벳 정렬, course의 숫자 정렬
        for(int i=0; i<orders.length; i++){
            String[] tem = orders[i].split("");
            Arrays.sort(tem);
            StringBuffer buf = new StringBuffer();
            for(String s : tem){
                buf.append(s);
            }
            orders[i] = buf.toString();
        }
        Arrays.sort(course);
        
       
        //orders 문자 길이 순으로 정렬
        Arrays.sort(orders,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }
                return s1.length()-s2.length();
            }
        });
        
        // ex> 메뉴2개 - "AB" - 주문개수
        HashMap<Integer,HashMap<String,Integer>> courseMap
            = new HashMap<>();

        ArrayList<String> result = new ArrayList<>();
        
        for(int i=0; i<course.length; i++){
            //course가 가능 한 개수이면
            if(orders[orders.length-1].length() >= course[i]){
                courseMap.put(course[i],new HashMap<String,Integer>());
                //길이가 course[i] 길이보다 큰 orders에 대해 
                //가능한 course[i] 개수의 조합을 만들고 hashMap의 count되어 저장
                for(String s : orders){
                    if(s.length() >= course[i]){
                        combination(s,course[i],0,courseMap.get(course[i]),new char[course[i]],0);
                    }
                }
                
                HashMap<String,Integer> cour = courseMap.get(course[i]);
                
                //주문수가 높은 순으로 key를 정렬 
                ArrayList<String> keys = new ArrayList<>(cour.keySet());
                Collections.sort(keys,new Comparator<String>(){
                    @Override
                    public int compare(String s1, String s2){
                        return -1*(cour.get(s1) - cour.get(s2)); 
                    }
                });
                
                //주문이 2회 이상이고 
                int max = cour.get(keys.get(0));
                if(max >= 2){
                    //제일 높은 수 저장
                    result.add(keys.get(0));
                    
                    //높은 수 동일하면 추가 저장
                    for(int k = 1; k<keys.size(); k++){
                        String s = keys.get(k);
                        int num = cour.get(s);
                        if(num == max){
                            result.add(s);
                        } else {
                            break;
                        }
                    }
                } //end if               
            }
        }
        
        Collections.sort(result);
        answer = result.toArray(String[]::new);
        return answer;
    }
    
    public static void combination(String s, int k,int index, HashMap<String,Integer> cour, char[] buf,int choiceIdx){
        if(k == 0){
            //조합 완료
            String com = new String(buf);
            cour.put(com,cour.getOrDefault(com,0)+1);
            return;
        }
        
        if(s.length() == choiceIdx) return; //조합 불가
         
        buf[index] = s.charAt(choiceIdx);
        combination(s,k-1,index+1,cour,buf,choiceIdx+1); //선택
        combination(s,k,index,cour,buf,choiceIdx+1); //미 선택
        
    }
}