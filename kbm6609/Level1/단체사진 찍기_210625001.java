package Group_Photo;


import java.util.HashMap;

public class GroupPhoto_210625001 {
    public static void main(String[] args) {
        String[] data={"N~F=0", "R~T>2"};
        int answer =0;
        char[][] ch ={{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'},{'0','0','0','0','0','0','0','0'}};
        HashMap<Character,Integer> hs=new HashMap<>();
        answer =run(hs,ch,0,data);
        System.out.println(answer);
    }
    static int run(HashMap<Character,Integer> h, char[][] ch, int index, String[] data){
        HashMap<Character,Integer> hs =new HashMap<>(h);
        int sum=0;
        if(index ==ch[0].length){
            sum +=check(hs,data);
        }
        else{
            for(int j= 0;j<ch[0].length;j++){
                if(ch[1][j]=='0'){
                    hs.put(ch[0][j],index);
                    ch[1][j] ='1';
                    sum+=run(hs,ch,index+1,data);
                    ch[1][j]='0';
                    hs.remove(ch[0][j]);
                }
            }
        }
        return sum;
    }
    static int check(HashMap<Character, Integer> hs,String[] data){
        int re=0;
        for (int i = 0; i < data.length; i++) {
            int a=Math.abs(hs.get(data[i].charAt(0))-hs.get(data[i].charAt(2)))-1;
            int b=(int)(data[i].charAt(4)-'0');
            if (data[i].charAt(3) == '=' && a ==b) re=1;
            else if(data[i].charAt(3) == '>'&&a >b) re=1;
            else if(data[i].charAt(3) == '<'&&a < b)re=1;
            else{
                re =0;
                break;
            }
        }
        return re;
    }
}
