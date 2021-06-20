class Solution {
    public int solution(String dartResult) {
    
        int[] numbers = new int[3];
        int count = -1;
        for(int i=0; i<dartResult.length(); i++){
            
            char c = dartResult.charAt(i);
            
            switch(c){
                case '*':
                    numbers[count] = 2*numbers[count];                    
                    if(count > 0){
                        numbers[count-1] = 2*numbers[count-1];
                    }
                    break;
                case '#':
                    numbers[count] = (-1)*numbers[count];
                    break;
                case 'S':
                    break;
                case 'D':
                    numbers[count] = (int)Math.pow(numbers[count],2);
                    break;
                case 'T':
                    numbers[count] = (int)Math.pow(numbers[count],3);
                    break;
                default:
                    //10인경우
                    int num = 0;
                    if(c-'0' == 1){
                        char cc = dartResult.charAt(i+1);
                        if(cc -'0' == 0){
                            i++;
                            num = 10;
                        } else{
                            num = c -'0';     
                        }
                    } else{
                        num = c -'0';                   
                    }
                    numbers[++count] = num;
                    break;
            }
        }
        int answer = 0;
        for(int s : numbers){
            answer += s;
        }
        
        return answer;
    }
}