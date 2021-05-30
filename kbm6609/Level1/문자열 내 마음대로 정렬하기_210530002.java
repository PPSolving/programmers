package String_Sort_As_You_Please;

import java.util.ArrayList;
import java.util.Collections;

class Stringsort implements Comparable<Stringsort>{
    String str;
    int n;
    Stringsort(String str,int n){
        this.str =str;
        this.n =n;
    }


    @Override
    public int compareTo(Stringsort o) {
        if(this.str.charAt(n)==o.str.charAt(n)){
            return this.str.compareTo(o.str);
        }
        else{
            return this.str.charAt(n)>o.str.charAt(n)? 1:-1;
        }
    }
}

public class StringSortAsYouPlease_210530002 {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        ArrayList<Stringsort> tmp =new ArrayList<>();
        for(String str:strings){
            tmp.add(new Stringsort(str,n));
        }
        Collections.sort(tmp);
        String[] answer=new String[strings.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] =tmp.get(i).str;
        }
        for(String i:answer){
            System.out.println(i);
        }
    }
}
