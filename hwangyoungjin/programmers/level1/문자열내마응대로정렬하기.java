import java.util.*;

class Str implements Comparable<Str>{
    String word;
    int n;
    
    public Str(String word, int n){
        this.n=n;
        this.word = word;
    }
    
    @Override
    public int compareTo(Str o){
        //n 번째 값이 같으면 String 전체로 비교
        if(this.word.charAt(this.n) == o.word.charAt(o.n)){
            return this.word.compareTo(o.word);
        }
        return this.word.charAt(this.n) < o.word.charAt(o.n) ? -1 : 1;
    }
}

class Solution {
    public String[] solution(String[] strings, int n) {
        //n : 0~
        ArrayList<Str> list = new ArrayList<>();
        
        for(String s : strings){
            list.add(new Str(s,n));
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).word;
        }
        
        return answer;
    }
}