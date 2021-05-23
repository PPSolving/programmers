package new_id_Recommendation;

public class newidRecommendation_210523001 {
    public static void main(String[] args) {
        String new_id=".asdqweqwzxc.12.123.";

        new_id=new_id.toLowerCase().replaceAll("[^a-z|0-9|_|\\-|.]|","").replaceAll("[.]{2,}",".");


        int s=0,e=new_id.length()-1;
        if(s==e && new_id.charAt(0) == '.') new_id ="a";
        else {
            if (new_id.charAt(0) == '.') s++;
            if (e-s >=15) e=s+14;
            if (new_id.charAt(e) != '.') e++;
            new_id =new_id.substring(s,e);
        }
        while(new_id.length()<3) new_id+= new_id.charAt(new_id.length()-1);
        System.out.println(new_id.length());
        System.out.println(new_id);
    }

}
