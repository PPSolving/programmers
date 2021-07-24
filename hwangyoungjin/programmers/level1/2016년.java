class Solution {
    public String solution(int a, int b) {
        //each month sum of days
        int[] month = new int[]{0,31,60,91,121,152,182,213,244,274,305,335,366};
        
        int total = month[a-1]+b;
        int remain = total%7;
        
        String[] week = new String[]{"THU","FRI","SAT","SUN","MON","TUE","WED"};
        
        String answer = week[remain];
    
        return answer;
    }
}