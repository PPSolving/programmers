class DFS{
    
    int count;
    int[] numbers;
    int k;
    
    DFS(int num, int[] numbers, int k){
        count =0;
        this.numbers = numbers;
        this.k = k;
    }
    
    public void dfs(int i, int sum){
        
        //전체 끝났고 값이 k이면 true 반환 아니면 false 반환
        if(i == numbers.length){
            if(sum == k) count++;
            return;
        }
        
        //1. +
        int checkSum = sum+numbers[i];
        dfs(i+1, checkSum);        
        
        //2. -
        checkSum = sum-numbers[i];
        dfs(i+1, checkSum);        
    }
}

class Solution {    
    public int solution(int[] numbers, int target) {
        
        DFS nums = new DFS(numbers.length, numbers, target);
        nums.dfs(0,0);
        return nums.count;
    }
}