package samsung.backjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


class Node implements Comparable<Node>{
    int id; //Node의 번호
    int w; //출발지 Start로 부터 해당 Node까지의 거리!

    public Node(int id, int w) {
        this.id = id;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w-o.w;
    }
}

public class P1753 {

    static int N,E,S;
    static ArrayList<ArrayList<Node>> adjList;
    static int[] distance; //출발지 Start로 부터 Node(idx = 노드번호)까지의 거리!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        S = sc.nextInt();

        adjList = new ArrayList<ArrayList<Node>>();
        distance = new int[N+1];

        //거리값 min으로 구해야 하므로 초기화
        for(int i=0; i<=N; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<Node>());
        }

        for(int i=0; i<E; i++){
            int v = sc.nextInt();
            int id = sc.nextInt();
            int w = sc.nextInt();
            adjList.get(v).add(new Node(id,w));
        }

        dijkstra(S);

        for(int i=1; i<distance.length; i++){
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else if (i == S){
                System.out.println(0);
            } else{
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작점 넣고 시작
        pq.add(new Node(start,0));
        //시작점 거리는 0으로
        distance[start] = 0;

        //더이상 방문 할 Node가 없을 때 까지
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            //1.도착지가 1개인 경우 도착하면 끝
            //if( cur.id == target) break;

            //2.더 큰 가중치로 도착한 경우 continue;
            if(cur.w > distance[cur.id]) continue;

            //3. 인접리스트 확인해서 최단거리이면 업데이트 후 pq.add
            for(Node next : adjList.get(cur.id)){
                if(distance[next.id] > distance[cur.id] + next.w){
                    distance[next.id] = distance[cur.id] + next.w;
                    pq.add(new Node(next.id,distance[next.id]));
                }
            }
        }
    }
}
