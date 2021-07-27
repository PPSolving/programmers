package samsung.backjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1922 {

    public static int[] parent;
    public static PriorityQueue<Edge> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //init
        pq = new PriorityQueue<>();
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        int M = sc.nextInt();
        for(int i=0; i<M; i++){
            int v = sc.nextInt();
            int u = sc.nextInt();
            int w = sc.nextInt();
            pq.add(new Edge(u,v,w));
        }

        System.out.println(kruskal(N));

    }
    public static int kruskal(int n){
        int cnt = 0;
        int total = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();

            //n-1개 까지만
            if(cnt == n-1) break;

            //같은 집합이면 pass
            if(find(e.u) == find(e.v)) continue;

            //다른집합 이면 해당 edge 선택
            union(e.v,e.u);
            cnt++;
            total += e.w;
        }
        return total;
    }
    public static void union(int a,int b){
        int pa = find(a);
        int pb = find(b);
        parent[pb] = pa;
    }
    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}


class Edge implements Comparable<Edge>{
    int v;
    int u;
    int w;

    public Edge(int v, int u, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w-o.w;
    }
}