package News_Clustering;

import java.util.HashMap;

public class NewsClustering_210718002 {
    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 ="shake hands";
        str1= str1.toLowerCase();
        str2= str2.toLowerCase();
        HashMap<String,Integer> s1=new HashMap<>();
        int cs1=0;
        int a=0;
        int b=0;
        for (int i = 0; i < str1.length() - 1; i++) {
            String ts= str1.substring(i,i+2).replaceAll("[^a-z]","");
            if(ts.length()==2) {
                s1.put(ts, s1.getOrDefault(ts,0)+1);
                cs1++;
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String ts= str2.substring(i,i+2).replaceAll("[^a-z]","");
            if(ts.length()==2) {
                if(s1.containsKey(ts)) {
                    a++;
                    s1.put(ts, s1.get(ts)-1);
                    if(s1.get(ts)==0) s1.remove(ts);
                }
                else  b++;
            }
        }
        int answer;
        double tmp;
        if(a+b+cs1!=0)tmp = (double)a/(cs1+b);
        else tmp=1;
        answer =(int)(tmp *65536);
        System.out.println(answer);
    }
}
