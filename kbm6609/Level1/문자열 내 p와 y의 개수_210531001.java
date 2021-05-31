package Number_Of_P_And_Y;

public class NumberOfPAndY_210531001 {
    public static void main(String[] args) {
        String s="pPoooyY";
        boolean answer = false;
        s = s.toLowerCase().replaceAll("[^(p||y)]", "");
        int pn =0;
        for(int i=0;i<s.length();i++) if(s.charAt(i)=='p') pn++;
        if(s.length() == pn*2) answer = true;
        System.out.println(answer);
    }
}
