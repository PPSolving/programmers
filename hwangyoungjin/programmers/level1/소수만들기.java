import java.util.*;
class Solution {
    public int solution(int[] nums) {
        //정렬
        Arrays.sort(nums);
        int su = 0;
        
        int max = nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        //소수 list
        List<Integer> sosuList = new ArrayList<>();
        
        int check = 0;
        //1부터 max까지 소수 구하기
        for(int i=2; i<=max; i++){
            check = 0;
            for(int j=2; j<i; j++){
                if(i%j == 0){
                    check = 1;
                }
            }
            
            if(check == 0){ // 소수
                sosuList.add(i);
            }
        }
        
        int answer = 0;
        
        Integer num = 0;
        //3자리 더하고 소수 안에 있는지 확인
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    num = nums[i]+nums[j]+nums[k];
                    if(sosuList.contains(num)){
//                        System.out.println("sosu : "+num);
                        //소수이므로 answer ++
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}