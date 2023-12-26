
public class Main {
    
    // final static int [] vertical = new int[15];
    final static int [] horizontal = new int[15];
    static int [][] heuristic = new int[8][8];;
    static float st = System.nanoTime();
    public static void main(String[] args) {
        int [][] board = new int[8][8];
        for(int i =0;i<=14;i++){horizontal[i] = i-7;}
        heuristic = heuristicG(heuristic); 
        int c = 0;
        // int e1 = -1;
        // int e2 = -1;
        int[] usedx = new int[100];
        int[] usedy = new int[100];
        int cc = 0;
        while(c!=8){
        Return select = mini(board,heuristic);
        if(c==1){
            usedx[cc] = select.getX();
            usedy[cc] = select.getY();
            cc++;
        }
        if(select.getX()==-1 && select.getY()==-1){
            board = new int[8][8];
            for(int rt = 0;rt<=cc;rt++){
                board[usedx[rt]][usedy[rt]] =2;
            }
            c=0;
        }
        else{
            c++;
            board[select.getX()][select.getY()] = 8;
            place(select.getX(),select.getY(),board);
            }}
            print1(board);
            System.out.println(c);
            System.out.println((System.nanoTime()-st)/1000000000);
        

        
 }
    static Return move(int r, int c, int i){
        int r1 = r;
        int c1 = c;
        if (i<=14){
            int y = r + horizontal[i];
            
            if(y>=0 && y<=7 ){r = y;}
        }
        if(i>14 && i<=29){
            int y = c + horizontal[i-15];
            if(y>=0 && y<=7 ){c = y;}
        }
        if(i>29 && i<=44){
            int y = r + horizontal[i-30];
            int z = c + horizontal[i-30];
            if(y>=0 && y<=7 && z>=0 && z<=7 ){
                r=y;
                c=z;
            }
            else{return new Return(-1,-1);}
        }
        if(i>44 && i<=59){
            int y = r + horizontal[i-45];
            int z = c - horizontal[i-45];
            if(y>=0 && y<=7 && z>=0 && z<=7 ){
                r=y;
                c=z;
            }
            else{return new Return(-1,-1);}
            
        }
        if(r1==r && c1==c){return new Return(-1, -1);}
        return new Return(r,c);
        

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
    static void print1(int[][] arr){
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(arr[i][j]==1) System.out.print("|"+" "+" ");
                else System.out.print("|"+"Q"+" ");
                
            }
            System.out.print("|");
            System.out.println("");
            System.out.println("------------------------");
        }
        System.out.println("");
    }
    

    
        static int [][] heuristicG(int [][] h){
        h = new int[8][8];
        for(int j = 0;j<=7;j++){
            for(int k = 0;k<=7;k++){
                int count = 0;
                for(int i =0;i<60;i++){
                    Return x = move(j,k,i);
                    if(x.getX()!=-1 && x.getY()!=-1){
                    // System.out.println(x.getX()+","+x.getY());
                    count+=1;
                }
                h[j][k] = count;
            }
            }
        }
        return h;
    }

    static Return mini(int [][] board,int [][] heuristic){
        int m = 30;
        int x = -1;
        int y = -1;
        for(int i=0;i<=7;i++){
            for(int j=0;j<=7;j++){
                if(heuristic[i][j]<m && board[i][j]!=1 && board[i][j]!=8 && board[i][j]!=2){
                    m = heuristic[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new Return(x, y);

    }
    
    static void place(int x,int y,int [][] board){
        for(int i =0;i<60;i++){
            Return z = move(x,y,i);
            if(z.getX()!=-1 && z.getY()!=-1){
            board[z.getX()][z.getY()] =1;
            // heuristic[z.getX()][z.getY()]--;}
        }

    }
}}
