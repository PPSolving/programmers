class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                for(int n=0; n<arr2[0].length; n++){
                    answer[i][n] += arr1[i][j]*arr2[j][n];
                }    
            }
        }
        return answer;
    }
}