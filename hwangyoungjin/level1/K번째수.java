import java.util.*;

class Solution { //O(n^2)
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        //주어진 commands에 맞춰 2차원 가변배열의 '열' 새로 만들기
        int[][] newArr = new int[commands.length][];
        
        for(int i=0; i<commands.length; i++){
            //commands[i]의 들어있는 값의 대해 필요한 만큼 '행' 새로만들기
            int n = commands[i][1]-commands[i][0]+1; //필요한 길이
            newArr[i] = new int[n]; //필요한 길이만큼 메모리 할당
            
            int a = commands[i][0]-1; //시작 index
            int b = commands[i][1]-1; //종료 index
            int c = 0; //newArr에 순차적으로 들어갈 index
            for(int j=a; j<=b; j++){ //array 배열값 복사
                newArr[i][c++] = array[j];
            }
            //해당 배열 정렬
            Arrays.sort(newArr[i]);
            int k = commands[i][2]-1; // return할 위치 k 값
            answer[i] = newArr[i][k]; // 정렬된 배열에서 위치k값 넣기
        }
        return answer;
    }
}