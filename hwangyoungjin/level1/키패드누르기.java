class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();

        //1,4,7은 무조건 L 
        //3,6,9는 무조건 R
        //(y,x)
        int[] left = new int[]{3,0};
        int[] right = new int[]{3,2};
        int[] center = new int[2];
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                if(numbers[i] == 1){
                    left[0] = 0;
                    left[1] = 0;
                } else if(numbers[i] == 4){
                    left[0] = 1;
                    left[1] = 0;
                } else{
                    left[0] = 2;
                    left[1] = 0;
                }
                answer.append("L");
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                if(numbers[i] == 3){
                    right[0] = 0;
                    right[1] = 2;
                } else if(numbers[i] == 6){
                    right[0] = 1;
                    right[1] = 2;
                } else {
                    right[0] = 2;
                    right[1] = 2;
                }
                answer.append("R");
            } else { // 가운데 라인
                int leftLen = 0;
                int rigthLen = 0;
                if(numbers[i] == 2){
                    center[0] = 0;
                    center[1] = 1;
                } else if(numbers[i] == 5){
                    center[0] = 1;
                    center[1] = 1;
                    
                } else if(numbers[i] == 8){
                    center[0] = 2;
                    center[1] = 1;
                } else{
                    center[0] = 3;
                    center[1] = 1;
                }
                
                leftLen = Math.abs((center[0]-left[0]))+Math.abs((center[1]-left[1]));
                rigthLen = Math.abs((center[0]-right[0]))+Math.abs((center[1]-right[1]));
                
                if(leftLen == rigthLen){
                    if(hand.equals("right")){
                        right[0] = center[0];
                        right[1] = center[1];
                        answer.append("R");
                    } else{
                        left[0] = center[0];
                        left[1] = center[1];
                        answer.append("L");
                    }
                } else if(leftLen < rigthLen){
                    left[0] = center[0];
                    left[1] = center[1];
                    answer.append("L");
                } else{
                    right[0] = center[0];
                    right[1] = center[1];
                    answer.append("R");
                }
            }
        }
        return answer.toString();
    }
}