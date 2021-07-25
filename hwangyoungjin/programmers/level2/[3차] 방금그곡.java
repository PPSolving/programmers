import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        Map<String, String> musicMap = new LinkedHashMap<>();
        for(String s : musicinfos){
            String[] musArr = s.split(",");
            String[] startArr = musArr[0].split(":");
            String[] endArr = musArr[1].split(":");
            int minute = 60*(Integer.parseInt(endArr[0])-Integer.parseInt(startArr[0]))
                + (Integer.parseInt(endArr[1])-Integer.parseInt(startArr[1]));
            StringBuffer buf = new StringBuffer();
            int idx = 0;
            int count = 0;
            int musLen = musArr[3].length();
            while(minute > 0){
                char ch = musArr[3].charAt(idx++);
                switch(ch){
                    case 'C':
                    case 'D':
                    case 'F':
                    case 'G':
                    case 'A':
                        if(idx != musLen && musArr[3].charAt(idx) == '#'){
                            ch = (char)((int)ch + ('a'-'A'));
                            idx++;
                        }
                        break;
                }
                buf.append(ch);
                idx %= musLen;
                minute--;
            }
            //System.out.println("title : "+musArr[2]+", music : "+buf.toString());
            musicMap.put(buf.toString(),musArr[2]);
        }
        
        //m convert not included '#' 
        StringBuffer bufM = new StringBuffer();
        int i = 0;
        int mLen = m.length();
        while(i<mLen){
            char cc= m.charAt(i++);
            switch(cc){
                    case 'C':
                    case 'D':
                    case 'F':
                    case 'G':
                    case 'A':
                        if(i != mLen && m.charAt(i) == '#'){
                            cc = (char)((int)cc + ('a'-'A'));
                            i++;
                        }
                        break;
                }
            bufM.append(cc);
        }
        m = bufM.toString();
        
        //LinkedHashMap is stable
        ArrayList<String> keyArr = new ArrayList<>();
        for(String k : musicMap.keySet()){
            keyArr.add(k);
        }
        
        //Longer is a priority , Stable Sort
        Collections.sort(keyArr,new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                return s2.length()-s1.length();
            }
        });
        
        //find m
        for(String key : keyArr){
            if(key.contains(m)) return musicMap.get(key);
        }
        
        return "(None)";
    }
}