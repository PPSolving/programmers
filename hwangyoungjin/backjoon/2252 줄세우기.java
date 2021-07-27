package samsung.backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252 {
    static ArrayList<ArrayList<Integer>> adjList;
    static int[] inDegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<Integer>());
        }
        inDegree = new int[N+1];

        int M = sc.nextInt();
        for(int i=0; i<M; i++) {
            int before = sc.nextInt();
            int after = sc.nextInt();
            inDegree[after]++;
            adjList.get(before).add(after);
        }
        dag();
    }
    public static void dag(){
        Queue<Integer> queue = new LinkedList<>();
        int idx = 0;

        for(int i=1; i<inDegree.length; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        StringBuffer buf = new StringBuffer();

        while(!queue.isEmpty()){
            int cur = queue.poll();
            buf.append(cur+" ");
            for(int next : adjList.get(cur)){
                inDegree[next]--;
                if (inDegree[next] == 0) queue.add(next);
            }
        }
        buf.delete(buf.length()-1,buf.length());
        System.out.println(buf.toString());
    }
}
