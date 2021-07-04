package Rotating_Matrix_Borders;

public class RotatingMatrixBorders_210703002 {
    public static void main(String[] args){

        int rows =3;
        int columns=3;
        int[][] queries={{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};


        int[][] maps=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++) {
                maps[i][j] = (i) * columns + j + 1;
            }
        }
        int[][] move ={{1,0},{0,1},{-1,0},{0,-1}};
        int[] answer= new int[queries.length];


        for(int i=0;i<answer.length;i++){
            int nr = queries[i][2] - queries[i][0]+1;
            int nc = queries[i][3] - queries[i][1]+1;
            int moveidex = -1;
            int x =queries[i][1]-1;
            int y =queries[i][0]-1;
            int num1 = maps[y + 1][x];  //num1 은 이전에 위치한 값을 저장할 변수
            int num2;                   // num2 는 현재 위치한 곳의 값을 저장하고 num1 에넘겨줄떄 쓸 변수
            answer[i] = maps[y][x];
            for(int j=0;j<(nr+nc-2)*2 ; j++){
                num2 = maps[y][x];
                if(answer[i] >num2) answer[i] =num2;
                maps[y][x] = num1;
                num1 = num2;
                if((x==queries[i][1]-1 || x==queries[i][3]-1)&&
                        (y==queries[i][0]-1 || y==queries[i][2]-1)) moveidex++;
                x += move[moveidex][0];
                y += move[moveidex][1];
            }
            //회전후 행렬상태 확인 코드
         /*   for(int w=0;w<rows;w++){
                for(int e=0;e<columns;e++) {
                    System.out.print(maps[w][e] +"\t");
                }
                System.out.println();
            }
            System.out.println("\n");*/
        }
        for(int i:answer) System.out.println("i = " + i);;

    }
}
