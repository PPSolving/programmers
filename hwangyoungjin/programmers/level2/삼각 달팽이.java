import java.util.*;
class Solution {
    public int[] solution(int n) {
        if(n == 1) return new int[]{1};
        
        int total = 0;
        int count = n;
        while(count > 0){
            total += count;
            count--;
        }
        
        //앞, 뒤로 붙이기
        ArrayList<LinkedList<Integer>> front = new ArrayList<>();
        ArrayList<LinkedList<Integer>> back = new ArrayList<>();
        for(int i=0; i<=n; i++){
            front.add(new LinkedList<Integer>());
            back.add(new LinkedList<Integer>());
        }
        
        int start = 1;
        int end = n;
        int num = 1;
        while(num < total){
            for(int i = start; i<end; i++){
                front.get(i).add(num++);
            }    
            while(front.get(end).size()+back.get(end).size() < end){
                front.get(end).add(num++);
            }
            start += 1;
            end -= 1;
            
            if(start > end) break;
            
            for(int i = end; i>=start; i--){
                back.get(i).addFirst(num++);
            }
            start +=1;
            
            if(start == end){
                while(front.get(end).size()+back.get(end).size() < end){
                    front.get(end).add(num++);
                }
                break;
            }
        }
        
        //copy
        int[] answer = new int[total];
        int idx = 0;
        for(int k=1; k<=n; k++){
            for(int su : front.get(k)){
                answer[idx++] = su;
            }
            for(int su : back.get(k)){
                answer[idx++] = su;
            }
        }
        return answer;
    }
}