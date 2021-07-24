import java.util.*;

class Node implements Comparable<Node>{
    int v;
    int w;
    Node(int v,int w){
        this.v=v;
        this.w=w;
    }
    @Override
    public boolean equals(Object o){
        Node n = (Node) o;
        return (this.v==n.v);
    }
    
    @Override
    public int compareTo(Node n){
        return this.w - n.w;
    }
}

class Graph{
    int vNum;
    ArrayList<ArrayList<Node>> graph;
    int[] distances;
    boolean[] visit;
    Graph(int num){
        this.vNum = num;
        distances = new int[num+1];
        visit = new boolean[num+1];
        graph = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<=num; i++){
            graph.add(new ArrayList<Node>());
        }
    }
    
    //bidirection
    public void createEdge(int v, int u, int w){
        graph.get(v).add(new Node(u,w));
        graph.get(u).add(new Node(v,w));            
    }
    
    //Dijkstra
    public void dijkstra(int start){
        visit[start] = true;
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visit[cur.v] = true;
            for(Node next : graph.get(cur.v)){
                if(visit[next.v]) continue;
                
                if(distances[next.v] > distances[cur.v] + next.w){
                    distances[next.v] = distances[cur.v] + next.w;
                    pq.add(new Node(next.v, distances[next.v]));
                }
            }
        }
    }
    
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        Graph graph = new Graph(N);
        
        for(int i=0; i<road.length; i++){
            graph.createEdge(road[i][0],road[i][1],road[i][2]);
        }
        
        graph.dijkstra(1);
        for(int dis : graph.distances){
            if(dis <= K) answer++;
        }
        return answer;
    }
}