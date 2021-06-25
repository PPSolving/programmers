class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int yIdx = 0;
        int xIdx = 0;
        for(int y=0; y<arr1.length; y++){
            int sum = 0;
            for(int x=0; x<arr1[0].length; x++){
               answer[y][x] = arr1[y][x]+arr2[y][x]; 
            }                
        }
        return answer;
    }
}