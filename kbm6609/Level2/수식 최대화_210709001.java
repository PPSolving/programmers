package Maximizing_Formulas;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class MaximizingFormulas_210709001 {
    public static void main(String[] args) {
        String expression ="0-200*0-500+20";
        long answer =-1;

        String[] num =expression.split("[^0-9]");
        char[] pa = expression.replaceAll("[0-9]", "").toCharArray();
        int[][] pripa ={{0,1,2},{0,2,1},{1,2,0},{1,0,2},{2,0,1},{2,1,0}};
        HashMap<Character,Integer> hs =new HashMap<>();
        hs.put('+',0);
        hs.put('-',1);
        hs.put('*',2);
        Vector< Stack<Long>> stnum =new Vector<>();
        Vector< Stack<Character>> stpa =new Vector<>();
        for(int i=0;i<6;i++){
            stnum.add(new Stack<>());
            stpa.add(new Stack<>());
            stnum.get(i).push(Long.valueOf(num[0]));
        }
        for(int i=0;i<pa.length;i++) {
            for(int j=0;j<pripa.length;j++){
                while(!stpa.get(j).isEmpty()&&pripa[j][hs.get(pa[i])]  < pripa[j][hs.get(stpa.get(j).peek())]){
                    char t=stpa.get(j).pop();
                    if(t=='-'&&!stpa.get(j).isEmpty()&&stpa.get(j).peek()=='-')  t= '+';
                    stnum.get(j).push(run(stnum.get(j).pop(),stnum.get(j).pop(),t));
                }
                stnum.get(j).push(Long.valueOf(num[i+1]));
                stpa.get(j).push(pa[i]);
            }
        }
        for(int j=0;j<pripa.length;j++){
            while(!stpa.get(j).isEmpty()){
                char c=stpa.get(j).pop();
                if(c=='-'&&!stpa.get(j).isEmpty()&&stpa.get(j).peek()=='-') c= '+';
                stnum.get(j).push(run(stnum.get(j).pop(),stnum.get(j).pop(),c));
            }
            if(Math.abs(stnum.get(j).peek()) > answer) answer =Math.abs(stnum.get(j).pop());
        }
        System.out.println(answer);
        }
    static long run(long a,long b,char ch){
        switch(ch){
            case '+':
                return a + b;
            case '-':
                return b-a;
            default:
                return a*b;
        }
    }
}
