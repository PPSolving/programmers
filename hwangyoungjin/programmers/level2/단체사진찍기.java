import java.util.*;

class Solution {
    static int answer;
    public int solution(int n, String[] data) {
        char[] friends = new char[]{'A','C','F','J','M','N','R','T'};
        boolean[] used = new boolean[friends.length]; 
        answer = 0;
        permutation(0,friends,used,new StringBuffer(),data);
        
        return answer;
    }
    public static void permutation(int num,char[] friends,boolean[] used,StringBuffer buf,String[] data){
        //모두 선택한 경우
        if(num == friends.length){
            //해당 조합 가능한지 체크
            if(check(buf, friends, data)) answer++;
            return;
        }
        
        for(int i=0; i<friends.length; i++){
            if(!used[i]){
                used[i] = true;
                buf.append(friends[i]);
                //선택했으므로 num+1
                permutation(num+1,friends,used,buf,data);
                buf.delete(buf.length()-1,buf.length());
                used[i] = false;
            }
        }
    }
    public static boolean check(StringBuffer buf,char[] friends,String[] data){
        for(String s : data){
            char f = s.charAt(0);
            char e = s.charAt(2);
            char con = s.charAt(3);
            int num = Integer.parseInt(s.charAt(4)+"");
            int dif = 0;
            switch(con){
                case '=':
                    dif = (int)Math.abs(buf.indexOf(f+"")-buf.indexOf(e+""))-1;
                    if(dif != num) return false;
                    break;
                case '>':
                    dif = (int)Math.abs(buf.indexOf(f+"")-buf.indexOf(e+""))-1;
                    if(dif <= num) return false;
                    break;
                case '<':
                    dif = (int)Math.abs(buf.indexOf(f+"")-buf.indexOf(e+""))-1;
                    if(dif >= num) return false;
                    break;
            } 
        }
        return true;
    }
}