import java.util.*;

class Solution {
    public int solution(String numbers) {
        
        int[] nums = new int[numbers.length()];
        
        //하나의 숫자로 구분
        for(int i=0; i<numbers.length(); i++){
            nums[i] = numbers.charAt(i) - '0';
        }
        
        //num의 대해 가능한 숫자 만들기
        HashMap<String,Integer> numMap = new HashMap<>();
        StringBuffer buf = new StringBuffer();
        boolean[] used = new boolean[nums.length];
        permutation(buf, numMap, 0, nums,used);
        
        int answer = 0;

        Set<String> numSet = numMap.keySet();
        
        //숫자 m에 대해 루트
        for(String s : numSet){
           // System.out.println("s : "+s);
                    
            int m = Integer.parseInt(s);
            if(m == 1){
                continue;
            }
            int k = (int) Math.sqrt(m);
            boolean result = true;
            for(int i=2; i<=k; i++){
                if(m%i == 0){
                    //소수아니므로
                    result = false;
                    break;
                }
            }
            if(result){
                answer++;
            }
        }
        return answer;
    }
    
    //idx는 조합하는 숫자의 index 위치
    public static void permutation(StringBuffer buf, HashMap<String,Integer> numMap, int idx, int[] nums, boolean[] used){
        if(idx == nums.length){
            //모두 저장 완료
            numMap.put(buf.toString(), Integer.parseInt(buf.toString()));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(idx == 0 && nums[i] == 0){
                continue;   
            }
            if(!used[i]){
                used[i] = true;
                buf.append(nums[i]);
                numMap.put(buf.toString(), Integer.parseInt(buf.toString()));
                permutation(buf, numMap, idx+1, nums,used);
                buf.deleteCharAt(idx);
                used[i] = false;
            }
        }
    }
}