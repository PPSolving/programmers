package The_Song_Just_Now;

import java.util.*;

class music implements Comparable<music>{
    String[] s ;
    int rank;
    int time;
    music( String s, int r){
        this.s=s.split(",");
        this.rank =r;
        time =timerun();
        chage();
    }
    int timerun(){
        String[] start = s[0].split(":");
        String[] end = s[1].split(":");
        return Integer.valueOf(end[0])*60+Integer.valueOf(end[1])-Integer.valueOf(start[0])*60-Integer.valueOf(start[1]);
    }
    void chage (){
        String[] tmp ={"C#","c","D#","d","F#","f","G#","g","A#","a"};
        for(int j=0;j<tmp.length;j+=2) s[3] = s[3].replaceAll(tmp[j],tmp[j+1]);
    }
    @Override
    public int compareTo(music o) {
        if(this.time!= o.time) return o.time - this.time;
        else return this.rank-o.rank;
    }
}
public class TheSongJustNow_210723001 {
    public static void main(String[] args) {

        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:30,HELLO,A#G#F#D#C#", "13:00,13:05,WORLD,ABCDEF"};
        List<music> arr =new ArrayList<>();
        for(int i=0;i<musicinfos.length;i++) arr.add(new music(musicinfos[i],i));
        Collections.sort(arr);

        String answer="";
        String[] tmp ={"C#","c","D#","d","F#","f","G#","g","A#","a"};
        for(int i=0;i<tmp.length;i+=2) m = m.replaceAll(tmp[i],tmp[i+1]);
        for (int i = 0; i < musicinfos.length; i++) {
            StringBuilder rsong = new StringBuilder();
            music  t =arr.get(i);
            for(int j=0;j<t.time/t.s[3].length();j++) rsong.append(t.s[3]);
            rsong.append(t.s[3].substring(0,t.time%t.s[3].length()));
            if(rsong.indexOf(m)>=0){
                answer=t.s[2];
                break;
            }
        }
        if(answer.equals("")) answer ="(None)";
        System.out.println(answer);
    }
}
