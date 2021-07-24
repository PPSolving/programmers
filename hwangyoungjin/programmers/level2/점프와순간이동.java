import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1; //1번은 무조건 써야함
        int step = 1;
        //뒤로가면서 check
        while(n != 1){
            if(n%2 != 0){
                n -= 1;
                ans += 1;
            }
            n /= 2;
        }    
        return ans;
    }
}