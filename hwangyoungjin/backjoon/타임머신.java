package samsung.backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P11657 {

    static ArrayList<Edge> edgeList; //모든 edge
    static long[] dist; // 음수간선 있으므로 V*E*(-COST)
    static int N,M; //V < 500, E < 6000
    static boolean time= false; // true : 음수사이크 발생

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        edgeList = new ArrayList<Edge>();
        dist = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int u = sc.nextInt();
            int w = sc.nextInt();
            edgeList.add(new Edge(v, u, w));
        }

        bellman(1);
        if(time) System.out.println("-1");
        else{
            for (int i = 2; i<=N; i++){
                if(dist[i] == Integer.MAX_VALUE) System.out.println("-1");
                else System.out.println(dist[i]);
            }
        }
    }

    public static void bellman(int start){
        //N-1번 순환 하면서 간선 M개 전체보기
        dist[start] = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                Edge e = edgeList.get(j);

                //출발지가 무한대이면 연산 X
                if (dist[e.from] == Integer.MAX_VALUE) continue;

                //거리 갱신
                dist[e.to] = Math.min(dist[e.to], dist[e.from] + e.w);
            }
        }
        //마지막 한번 더 보기
        for(int j=0; j<M; j++){
            Edge e = edgeList.get(j);
            if(dist[e.from] == Integer.MAX_VALUE) continue;

            //최단 거리 찾은 상태에서 최단거리가 또 나온다는것은 음수 사이클!!
            if(dist[e.to] > dist[e.from] + e.w){
                time = true;
            }
        }

    }
    protected static class Edge{
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
}

