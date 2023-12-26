import java.util.Arrays;
import java.util.Random;

public class Main {
    final static int [] horizontal = {2,1,-1,-2,-2,-1,1,2};
    final static int [] vertical = {-1,-2,-2,-1,1,2,2,1};
    final static int [][] accessiblity = {{2,3,4,4,4,4,3,2},{3,4,6,6,6,6,4,3},
                                            {4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4},
                                            {4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4},
                                            {3,4,6,6,6,6,4,3},{2,3,4,4,4,4,3,2 }};
    public static void main(String[] args) {
        
        int [][] board = new int[8][8];
        int r = 0;
        int c = 0;
        int counter = 2;
        board[r][c] = 1;
        while(counter<=64){
        Return r1= moveGenerator(r, c);
        int check = test1(board,r1.getX(),r1.getY());
        if(check==1){
            r = r1.getX();
            c = r1.getY();
            board[r][c] = counter++;
            print(board);
            // break;
        }
        else{
            System.out.println(r1.getX());
            System.out.println(r1.getY());
        }
    
    
    }
    
    
    
    
    
    }

    static void print(int[][] arr){
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(arr[i][j]<10) System.out.print(arr[i][j]+"  ");
                else System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
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

    static Return  moveGenerator(int x,int y){
        Random rand = new Random();
        int choose  = rand.nextInt(7);
        x+=horizontal[choose];
        y+=vertical[choose];
        return new Return(x,y);
        }

    }

