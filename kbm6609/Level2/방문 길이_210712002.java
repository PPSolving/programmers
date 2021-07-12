package length_Of_Visit;

import java.util.HashMap;
import java.util.HashSet;

class point {
    HashSet<Character> laod;
    point(){
        this.laod =new HashSet<>();
    }
}
public class lengthOfVisit_210712002 {
    public static void main(String[] args) {
        String dirs="ULURRDLLU"	;
        point[][] st =new point[11][11];
        int x=5;
        int y=5;
        int answer= 0;
        st[x][y]= new point();
        HashMap<Character,Character> l =new HashMap<>();
        l.put('D','U');
        l.put('U','D');
        l.put('L','R');
        l.put('R','L');
        HashMap<Character,int[]> p =new HashMap<>();
        p.put('D',new int[]{0,-1});
        p.put('U',new int[]{0,1});
        p.put('L',new int[]{-1,0});
        p.put('R',new int[]{1,0});

        for(char i: dirs. toCharArray()){
            int nx =p.get(i)[0];
            int ny =p.get(i)[1];
            if (x + nx >= 0 && x + nx < 11 && y + ny >= 0 && y + ny < 11) {
                if (!st[x][y].laod.contains(i)) {
                    st[x][y].laod.add(i);
                    answer++;
                }
                x += nx;
                y += ny;
                if (st[x][y] == null) st[x][y] = new point();
                if (!st[x][y].laod.contains(l.get(i))) st[x][y].laod.add(l.get(i));
            }
        }
        System.out.println(answer);


    }
}
