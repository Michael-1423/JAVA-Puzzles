import java.util.Arrays;

public class Heuristic {
    static float st = System.nanoTime();
    final static int [] horizontal = {2,1,-1,-2,-2,-1,1,2};
    final static int [] vertical = {-1,-2,-2,-1,1,2,2,1};
    static int [][] accessiblity = {{2,3,4,4,4,4,3,2},{3,4,6,6,6,6,4,3},
                                            {4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4},
                                            {4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4},
                                            {3,4,6,6,6,6,4,3},{2,3,4,4,4,4,3,2 }};
    
    public static void main(String[] args) {
        int indi;
        int [][] board = new int[8][8];
        int r = 0;
        int c = 0;
        int counter = 2;
        board[r][c] = 1;
        while(counter<=64){
            int[] legal = new int[8];
            for(int i =0;i<=7;i++){
                Return r1= moveGenerator(r, c,i);
                int check = test1(board,r1.getX(),r1.getY());
                if(check==1) {
                    legal[i] = accessiblity[r1.getX()][r1.getY()]--;
                }
                
            }
            indi = mini(legal);

            Return r1= moveGenerator(r, c,indi);
            r = r1.getX();
            c = r1.getY();
            board[r][c] = counter++;
    }
    print(board);
    System.out.println((System.nanoTime()-st)/1000000000);
    }

    static void print(int[][] arr){
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(arr[i][j]<10) System.out.print("|"+arr[i][j]+"  ");
                else System.out.print("|"+arr[i][j]+" ");
            }
            System.out.println("|");
            System.out.println("---------------------------------");

        }
        System.out.println("");
    }
    static void print(int[] x){
        System.out.print("{");
        for(int i :  Arrays.copyOfRange(x,0,x.length-1) ){
            System.out.print(i+" , ");
        }
        System.out.print(x[x.length-1]+"}");
        System.out.println("");}


    static int test1(int [][] board,int r,int c){
        return ((r<=7 && r>=0) ? ((c<=7 && c>=0)?(board[r][c]==0 ?1:0):0):0); 
    }

    static Return  moveGenerator(int x,int y,int choose){
        x+=horizontal[choose];
        y+=vertical[choose];
        return new Return(x,y);
        }
    
    static int mini(int[] x){
        int m =10;
        int m1 = -1;
        for(int j=0;j<=7;j++){
            if(x[j]<m && x[j]!=0) {
                m1 = j;
                m = x[j];
            }
        }
        return m1;
    }    
    static int maxi(int[] x){
        int m =0;
        int m1 = -1;
        for(int j=0;j<=7;j++){
            m1 = ((x[j]>m && x[j]!=0)?j:m1);
        }
        return m1;
    }


    }


