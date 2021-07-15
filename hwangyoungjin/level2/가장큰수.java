import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        boolean check = true;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] != 0) check = false;
            strArr[i] = String.valueOf(numbers[i]);
        }
        if(check) return "0";
    	Arrays.sort(strArr, new Comparator<String>(){
           @Override
            public int compare(String o1, String o2){
                return Integer.parseInt((o2+o1)) - Integer.parseInt((o1+o2));
            }
        });
        StringBuffer buf = new StringBuffer();
        for(String i : strArr){
            buf.append(i);
        }
        
        return buf.toString();
    }
}