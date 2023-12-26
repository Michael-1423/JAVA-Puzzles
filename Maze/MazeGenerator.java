import java.util.Random;

public class MazeGenerator {
    int h;
    int w;
    static Main mm = new Main();
    MazeGenerator(int x,int y){
        setH(x);
        setW(y);
    }
    public int getH(){
        return h;
    }
    public int getW(){
        return w;
    }
    public void setH(int h) {
        this.h = h;
    }
    public void setW(int w) {
        this.w = w;
    }

    void print(int[][] arr){
        for(int i = 0;i<this.h;i++){
            for(int j = 0;j< this.w;j++){
                // if(arr[i][j]==1) System.out.print("|"+" "+" ");
                // else System.out.print("|"+"#"+" ");
                System.out.print("|"+arr[i][j]+" ");
            }
            System.out.print("|");
            System.out.println("");
            System.out.println("-------------------------------------");
        }
        System.out.println("");
    }

    public Return getStart() {
        int x =0;
        int y =0;
        Random r= new Random();
        int r1 = 1+ r.nextInt(4);
        switch (r1) {
            case 0:
                y=0;
                x = r.nextInt(this.h);
                break;
            case 1:
                x=0;
                y = r.nextInt(this.w);
                break;
            case 2:
                y=this.w-1;
                x = r.nextInt(this.h);
                break;
            case 3:
                x=this.h-1;
                x = r.nextInt(this.w);
                break;
        }
        // System.out.print("Start: ");
        // System.out.println(x + ","+ y);
        return new Return(x,y);
    }
    
    public Return getEnd() {
        int x = this.h-1;
        int y = this.w-1;
        Random r= new Random();
        int r1 = 1+ r.nextInt(4);
        switch (r1) {
            case 0:
                y=0;
                x = r.nextInt(this.h);
                break;
            case 1:
                x=0;
                y = r.nextInt(this.w);
                break;
            case 2:
                y=this.w-1;
                x = r.nextInt(this.h);
                break;
            case 3:
                x=this.h-1;
                x = r.nextInt(this.w);
                break;
        }
        // System.out.print("End: ");
        // System.out.println(x + ","+ y);
        return new Return(x,y);
    }
    public boolean  checkEnd(int x, int y) {
        // int x = this.h-1;
        // int y = this.w-1;
        // Random r= new Random();
        // int r1 = 1+ r.nextInt(4);
            if(y==0 || x ==0){ return true;}
            else if(x==this.h-1 || y == this.w-1){return true;}
            else{return false;}
        
    }

    public int[][] getMaze(){
        Return s = getStart();
        Return e = getEnd();
        Random r = new Random(10);
        int [][] maze = new int[this.h][this.w];
        for(int i = 0;i<this.h;i++){
            for(int j = 0;j<this.w;j++){
                if(i==0 || j==0){maze[i][j]=0;}
                else if(i==this.h-1 || j==this.w-1){maze[i][j]=0;}
                else{maze[i][j] = r.nextInt(2);}
            }
        }
        maze[s.getX()][s.getY()] =1;
        maze[e.getX()][e.getY()] =1;
        print(maze);
        return maze;

    }
    

    public int[][] getMaze1(){
        int [][] maze = new int[this.h][this.w];
        Return s = getStart();
        int x = s.getX();
        int y = s.getY();
        maze[x][y] =1;
        System.out.println(x+","+y);
        // Return n1 = choose(x,y);
        if(x==0){x++;}
        if(y==0){y++;}
        if(x ==this.h-1){x--;}
        if(y == this.h-1){y--;}
        System.out.println(x+","+y);
        // System.out.println(n1.getX()+","+n1.getY());
        // System.out.println(!checkEnd(n1.getX(),n1.getY()));
        while(!checkEnd(x,y)){
            Return n = choose(x,y);
            x = n.getX();
            y = n.getY();
            System.out.println("get");
            System.out.println(x+","+y);
            maze[x][y] = 1;
        }
        maze[x][y] =1;
        print(maze);
        return maze;


    }

    static Return up(int x,int y){return new Return(--x, y);}
        static Return down(int x,int y){return new Return(++x, y);}
        static Return left(int x,int y){return new Return(x, --y);}
        static Return right(int x,int y){return new Return(x, ++y);}

        Return choose(int x,int y){
            Random r = new Random();
            int z = 1+r.nextInt(4);
            switch(z) {
                case 1:
                    Return e = up(x,y);
                    e = (e.getX()>=0 && e.getX()<this.h ? e:new Return(x,y)); 
                    return e;
                case 2:
                    Return e1 = down(x,y);
                    e1 = (e1.getX()>=0 && e1.getX()<this.h ? e1:new Return(x,y)); 
                    return e1;
                case 3:
                    Return e2 = left(x,y);
                    e2 = (e2.getY()>=0 && e2.getY()<this.w ? e2:new Return(x,y)); 
                    return e2;
                case 4:
                    Return e3 = right(x,y);
                    e3 = (e3.getY()>=0 && e3.getY()<this.w ? e3:new Return(x,y)); 
                    return e3;
            }
            return new Return(0,0);

        }
    
        public int[][] getMaze2(){
           int [][] maze = {
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,1,1,1,1,1,1,0},
            {1,1,0,1,0,1,0,0,0,0,1,0},
            {0,0,0,1,0,1,1,1,1,0,1,0},
            {0,1,1,1,1,0,0,0,1,0,1,0},
            {0,0,0,0,1,0,1,0,1,0,1,0},
            {0,1,1,0,1,0,1,0,1,0,1,0},
            {0,0,1,0,1,0,1,0,1,0,1,1},
            {0,1,1,1,1,1,1,1,1,0,1,0},
            {0,0,0,0,0,0,1,0,0,0,1,0},
            {0,1,1,1,1,1,1,0,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0}};
            return maze;
    
    
        }
}
