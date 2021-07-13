import java.util.*;

class MyFile implements Comparable<MyFile>{
    String head;
    int num;
    String origin;
    MyFile( String head, int num,String origin){
        this.head = head;
        this.num = num;
        this.origin = origin;
    }
    
    @Override
    public int compareTo(MyFile m){
        if(!this.head.equals(m.head)) {
            return this.head.compareTo(m.head);
        }
        return this.num-m.num;
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        LinkedList<MyFile> list = new LinkedList<>();
        
        StringBuffer buf = new StringBuffer();
        StringBuffer numberBuf = new StringBuffer();
            
        for(int n =0; n<files.length; n++){
            String s = files[n];
            
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    int idx = i;
                    numberBuf.append(s.charAt(idx++));
                    while(idx < s.length() && s.charAt(idx) >= '0'
                          && s.charAt(idx) <= '9' && numberBuf.length() < 5){
                        numberBuf.append(s.charAt(idx++));
                    }
                    break;
                }
                buf.append(s.charAt(i));
            }    
            
            list.add(new MyFile(buf.toString().toUpperCase(),
                                Integer.parseInt(numberBuf.toString()),s));
            numberBuf.delete(0,numberBuf.length());
            buf.delete(0,buf.length());
        }
        
        Collections.sort(list);
        answer = new String[list.size()];
        int idx = 0;
        for(MyFile f : list){
            answer[idx++] = f.origin;
        }
        return answer;
    }
}