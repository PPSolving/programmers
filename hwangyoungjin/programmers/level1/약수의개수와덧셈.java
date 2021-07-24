class Solution {
    public int solution(int left, int right) {
        int answer = 0;    
        for(int i=left; i<=right; i++){
            if(measure(i)%2 == 0){ //약수 개수 짝수개
                answer += i;
            }else{
                answer -= i;
            }
        }
        
        return answer;

    }
    
    public static int measure(int num){
        double ch = Math.sqrt(num);
        int check = (int)(Math.sqrt(num));
        int count =2; 
        if(ch%check == 0){
            count +=1;
        }else{
            count +=2;
        }
        for(int i = 2; i<check; i++){
            if((num%i) == 0){
                count+=2;
            }
        }
        return count;
    }
}