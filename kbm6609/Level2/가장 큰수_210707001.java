package Largest_Number;

import java.util.*;

public class LargestNumber_210707001 {
    public static void main(String[] args) {
        int[] numbers = {341,3413413};
        HashMap<Integer,Integer> nre=new HashMap<>();
        for(int i:numbers) nre.put(i,nre.getOrDefault(i,0)+1);
        Integer[] nnum = nre.keySet().toArray(new Integer[0]);



        Arrays.sort(nnum);
     /*   for(int i:nnum){
            System.out.println("i = " + i);
        }*/
        StringBuilder str =new StringBuilder();
        String answer;
        boolean flag =true;
        HashMap<Integer, Queue<Integer>> hs =new HashMap<>();
        for (int i : nnum) {
            int num;
            if(i!=0) {
                flag = false;
                num =(int)Math.pow(10,(int)Math.log10(i));
            }
            else{
                num =1;
            }
            if(!hs.containsKey(i/num))
                hs.put(i/num,new LinkedList<>());
            hs.get(i/num).add(i);

        }
  /*      for(int i:hs.keySet()) {
            System.out.println(i);
        };
        System.out.println();*/
        if(!flag) {
            for(int i=9;i>=1;i--) {
                if (hs.containsKey(i)) {
                    int[] arr = new int[hs.get(i).size()];
                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = hs.get(i).poll();
                    }
                    for (int j = 0; j < arr.length-1; j++) {
                        for (int k = 0; k < arr.length - 1 - j; k++) {
                            int a = arr[k];
                            int b = arr[k + 1];
                                int na = (int) Math.pow(10, (int) Math.log10(a)) / 10;
                                int nb = (int) Math.pow(10, (int) Math.log10(b)) / 10;
                                int c=2*(na>nb?(int) Math.log10(a)+1:(int) Math.log10(b)+1);

                               for(int w= 0;w<c;w++) {
                                    if(na<=0){
                                        na =(int) Math.pow(10, (int) Math.log10(a));
                                    }
                                    if(nb<=0){
                                        nb =(int) Math.pow(10, (int) Math.log10(b));
                                    }
                                    if ((a / na)%10 < (b / nb)%10) {
                                        arr[k] =b;
                                        arr[k+1]=a;
                                        break;
                                    }else if((a / na)%10 > (b / nb)%10) {
                                        break;
                                    }
                                    na /= 10;
                                    nb /= 10;
                                }
                                // 여기서 부터

                        }
                    }
                    for(int h:arr){
                        for(int t=0;t<nre.get(h);t++)
                            str.append(h);
                    }
                }
            }
            if(hs.containsKey(0)){
                str.append("0".repeat(nre.get(0)));
            }
            answer= new String (str);
        }else {
             answer= "0";
        }
        System.out.println(answer);
// 마지막 제발 되자 ;;
// 세번째 스텍과 스트링으로 구현
//두번째 오로지 스트링으로 만 구현

//첫번쨰 실패
       /* int[] numbers = {1,121};

        Arrays.sort(numbers);
        StringBuilder  str  = new StringBuilder();

        HashMap<Integer,Integer> deci =new HashMap<>();
        HashMap<Integer, Stack<Integer>> hs =new HashMap<>();
        for (int i : numbers) {
            int len;
            if(i==0){
                len =0;
            }
            else
                len =(int)Math.log10(i);
            if (!hs.containsKey(len)) {
                hs.put(len,new Stack<>());
            }
            hs.get(len).push(i);
        }
  *//*      for(int i:hs.keySet()){
            System.out.println(i);
        }*//*
        int[] arr = new int[hs.size()];
        int index= 0;
        for(int i:hs.keySet()){
            int k=1;
            for(int j=0;j<i;j++) k*=10;
            deci.put(i, k);
            arr[index++] =i;
        }
        Arrays.sort(arr);


       for(int i=9;i>=0;i--){
//           System.out.println(i);
           int max;
           int maxindex=arr[0];
           boolean flag =false;
           for(int j:arr){
                   if (!hs.get(j).isEmpty()&&i == hs.get(j).peek() / deci.get(j)) {
                      if(!flag) {
                          flag = true;
                          maxindex = j;
                      }
                      else{
                          if (hs.get(maxindex).peek() < hs.get(j).peek() * deci.get(maxindex) / deci.get(j)) {
                                maxindex = j;
                          }
                          else if(hs.get(maxindex).peek() == hs.get(j).peek() * deci.get(maxindex) / deci.get(j)){
                              int k = hs.get(j).peek() % (deci.get(j) / deci.get(maxindex));
                              int decilen =deci.get(j) / (deci.get(maxindex)*10*deci.get(maxindex));
                              for(;decilen>0;decilen/=10*deci.get(maxindex)){
                                  if(k/decilen<hs.get(maxindex).peek()){
                                      System.out.println(k/decilen);
                                    break;
                                  }
                                  else if(k/decilen>hs.get(maxindex).peek()) {
                                      System.out.println(k/decilen);
                                      maxindex = j;
                                      break;
                                  }
                                  System.out.println(k/decilen);
                                  k%=decilen;
                              }
                          }
                      }

                   }
           }
           if(flag){
               i++;
               if(!(str.length()>0&&hs.get(maxindex).peek()==0&&str.charAt(0)=='0'))
                   str.append(hs.get(maxindex).pop());
               else
                   hs.get(maxindex).pop();
           }
       }
        System.out.println(str);*/
    }
}
