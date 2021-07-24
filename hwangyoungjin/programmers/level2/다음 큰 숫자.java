class Solution {
    public int solution(int n) {
        int result = 0;
        int nCount = countCheck(n);
        int checkNum = n;
        while(result != nCount){
            result = countCheck(++checkNum);
        }
        return checkNum;
    }
    public static int countCheck(int n){
        int numCount = 0;
        while(n > 0){
            int rest = n%2 == 0 ? 0 : 1;
            numCount = rest==1 ? numCount+1 : numCount;
            n /= 2;
        }
        return numCount;
    } 
}