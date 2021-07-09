package Stock_Price;


import java.util.Stack;

public class StockPrice_210708001 {
    public static void main(String[] args) {
        int[] prices ={1,2,3,2,3};
        Stack<Integer> up =new Stack<>();
        int[] answer =new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (!up.isEmpty()&&prices[up.peek()]> prices[i]){
                while (!up.isEmpty()){
                    if(prices[up.peek()] > prices[i]){
                        answer[up.peek()] = i-up.pop();
                    }else break;
                }
            }
            up.push(i);
        }
        while(!up.isEmpty()){
            answer[up.peek()] = prices.length-1 -up.pop();
        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }

    }
}
