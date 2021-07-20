package Sort_File_Names;

import java.util.*;

class Str implements Comparable<Str>{
    String H;
    int N;
    int rank;

    Str(String s,int r){
        this.rank =r;
        int j=0;
        boolean flag =false;
        for (int i = 0; i < s.length(); i++) {
            if(!flag&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                flag =true;
                H =s.substring(0,i);
                j=i;
            }else if(flag && !(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                N = Integer.valueOf(s.substring(j,i));
                flag = false;
                break;
            }
        }
        if(flag) N = Integer.valueOf(s.substring(j));
    }
    @Override
    public int compareTo(Str o) {
        int n=H.compareTo(o.H);
        if(n==0){
            if(N == o.N) return rank -o.rank;
            else return N-o.N;
        }
        else return n;
    }
}
public class SortFileNames_210720001 {
    public static void main(String[] args) {
        String[] files={"a1","img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        List<Str> str =new ArrayList<>();
        String[] answer =new String[files.length];
        for (int i = 0; i < files.length; i++) {
            str.add(new Str(files[i].toLowerCase(),i));
        }
        Collections.sort(str);
        for (int i = 0; i < str.size(); i++) {
            answer[i] =files[str.get(i).rank];
        }
    }
}
