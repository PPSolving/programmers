import java.util.*;

//4개 모인것 확인 후 0으로 대체
//0이 아닐때까지 아래로 내리기
class Point{
    int x;
    int y;
    Point(int a,int b){
        x=a;
        y=b;
    }
    @Override
    public boolean equals(Object o){
        Point p = (Point) o;
        return (this.x == p.x && this.y == p.y);
    }
}

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        ArrayList<LinkedList<String>> boardList = new ArrayList<>();
        for(int i=0; i<n; i++){
            boardList.add(new LinkedList<String>());
        }
        
        for(int c=m-1; c>=0; c--){
            String[] strArr = board[c].split("");
            int x = 0;
            for(String s : strArr){
                boardList.get(x++).add(new String(s));
            }
        }
        
        int num = check(boardList,answer);
        while(answer != num){ //같다는건 더이상 지울것 X
            answer = num;
            num = check(boardList,answer);
        }
        return answer;
    }
    public static int check(ArrayList<LinkedList<String>> boardList,int num){
        ArrayList<Point> remove = new ArrayList<>();
        int[][] directions = new int[][]{{0,1},{1,1},{1,0}};
        boolean total = true;
        
        for(int x=0; x<boardList.size()-1; x++){
            LinkedList<String> xList = boardList.get(x);
            for(int y=0; y<xList.size()-1; y++){
                
                boolean check = true;
                String cur = xList.get(y);
                
                for(int d=0; d<directions.length; d++){
                    
                    int nextY = y + directions[d][0];
                    int nextX = x + directions[d][1];
                    //short next line
                    if(boardList.get(nextX).size()-1 < nextY){
                        check = false;
                        break;
                    }
                    String tem = boardList.get(nextX).get(nextY);
                    if(!tem.equals(cur)) check = false;
                }
                System.out.println();
                if(check){
                    total = false;
                    remove.add(new Point(x,y));
                    for(int d=0; d<directions.length; d++){
                        int nextY = y + directions[d][0];
                        int nextX = x + directions[d][1];
                        String tem = boardList.get(nextX).get(nextY);
                        Point p = new Point(nextX,nextY);
                        if(!remove.contains(p)) remove.add(p);
                    }
                }
            }
        }
        if(!total){
            num = arrange(boardList,remove,num);
            remove.clear();
        }
        return num;
    }
    //guarantee horizontal(=x) :5 , changeable vertical(=y)
    public static int arrange(ArrayList<LinkedList<String>> boardList, ArrayList<Point> remove,int num){
        //remove에 있는 값이면 넣지 않는다.
        for(int i=0; i<boardList.size(); i++){
            LinkedList<String> replaceList = new LinkedList<>();
            LinkedList<String> origin = boardList.get(i);
            for(int y=0; y<origin.size(); y++){            
                if(!remove.contains(new Point(i,y))){ //제거 대상이 아니면
                    replaceList.add(origin.get(y));
                } else num++; //제거 되는 경우 num++
            }
            boardList.set(i,replaceList); //교체         
        }
        return num;
    }
}