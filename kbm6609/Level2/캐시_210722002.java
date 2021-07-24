package Cache;


import java.util.*;

class city implements Comparable<city> {
    String name;
    int time;
    city(String s,int t){
        this.name =s;
        this.time =t;
    }

    @Override
    public int compareTo(city o) {
        return this.time -o.time;
    }
}
public class Cache_210722002 {
    public static void main(String[] args) {
        int cacheSize =3 ;
        String[] cities= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        int answer =0;
        HashMap<String, city> hs = new HashMap<>();
        List<city> ca =new ArrayList<>();
        if(cacheSize==0) answer = cities.length*5;
        else {
            for (int i = 0; i < cities.length; i++) {
                String c =cities[i].toLowerCase();
                if (!hs.containsKey(c)) {
                    if (ca.size() == cacheSize) {
                        hs.remove(ca.get(0).name);
                        ca.remove(0);
                    }
                    hs.put(c, new city(c, i));
                    ca.add(hs.get(c));
                    answer += 5;
                } else {
                    hs.get(c).time = i;
                    answer++;
                }
                Collections.sort(ca);
            }
        }
        System.out.println(answer);
    }

}
