class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        /*
        Math.scalb(1,  5) // 32
        Math.scalb(1,  4) // 16
        */
        for(int i=0; i<n; i++){
            StringBuffer num = new StringBuffer();
            for(int su=n-1; su>=0; su--){
                int checkNum = (int)(Math.scalb(1,su));
                if( arr1[i]/checkNum == 1 && arr2[i]/checkNum == 1){
                    num.append("#");
                    arr1[i] -= checkNum;
                    arr2[i] -= checkNum;
                } else if(arr1[i]/checkNum == 1){
                    num.append("#");
                    arr1[i] -= checkNum;    
                } else if(arr2[i]/checkNum == 1){
                    num.append("#");
                    arr2[i] -= checkNum;
                } else {
                    num.append(" ");
                }
            }
            answer[i] = num.toString();
        }
        return answer;
    }
}