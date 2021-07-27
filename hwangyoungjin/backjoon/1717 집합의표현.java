package samsung.backjoon;

import java.util.Scanner;

public class P1717 {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n+1];

        //init
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int check = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(check == 1){
                if(find(a)==find(b)) System.out.println("YES");
                else System.out.println("NO");
            }else{ //check == 0
                union(a,b);
            }
        }
    }
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        parent[pb] = pa;
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
