class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int maxIdx = arr.length-1;
        
        compact(0,maxIdx,0,maxIdx,arr,answer);
        
        return answer;
    }
    
    public static void compact(int startX,int endX,int startY,int endY,
                               int[][] arr,int[] answer){
    
        if(startX == endX){
            answer[arr[startY][startX]]++;
            return;
        }
        
        int fix = arr[startY][startX];
        boolean check = true;
        for(int y=startY; y<=endY; y++){
            for(int x=startX; x<=endX; x++){
                if(fix != arr[y][x]){
                    check = false;
                    break;
                }  
            }
            if(!check) break;
        }    
        
        if(check){
            answer[fix]++;
        } else{ //4개로 재귀
            int intervalX = endX-startX;
            int intervalY = endY-startY;
            compact(startX,startX+(intervalX/2),
                    startY,startY+(intervalY/2),arr,answer);
            compact(startX,startX+(intervalX/2),
                    startY+(intervalY/2)+1,endY,arr,answer);
            compact(startX+(intervalX/2)+1,endX,
                    startY,startY+(intervalY/2),arr,answer);
            compact(startX+(intervalX/2)+1,endX,
                    startY+(intervalY/2)+1,endY,arr,answer);
        }
    }
}