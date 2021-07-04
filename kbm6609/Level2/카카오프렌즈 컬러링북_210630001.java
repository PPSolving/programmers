package Coloring_Book;

public class ColoringBook_210630001 {
    static boolean[][] check;
    public static void main(String[] args) {
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        int m=picture.length;
        int n = picture[0].length;

        check =new boolean[m][n];
        int c = 0,tmp =0;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((picture[i][j] !=0 && check[i][j]==false)) {
                    c++;
                    tmp = run(picture[i][j], i, j,picture);
                    if(max <tmp) max =tmp;
                }
            }
        }
        for(int[] i:picture){
            for(int j :i){
                System.out.print(j+"\t");
            }
        }
        System.out.println();
        System.out.println(c+" "+max+" ");
    }
    static int run(int num,int i,int j,int[][] picture){
        int sum =0;
        if((i< picture.length && i>=0 && j<picture[0].length && j>=0) && (picture[i][j] ==num && check[i][j]==false)){
            check[i][j] =true;
            sum +=1+run(num, i-1, j,picture)+run(num, i, j+1,picture)+run(num, i+1, j,picture)+run(num, i, j-1,picture);
        }
        return sum;
    }
}
