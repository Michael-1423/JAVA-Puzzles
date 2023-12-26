// import java.util.Random;



public class Main {
    
    static int count = 1;
    static MazeGenerator mm = new MazeGenerator(30,30);
    // static Return ee = mm.getEnd();
    // static int finalx = ee.getX();
    // static int finaly = ee.getY();
    // static Return curr = mm.getStart();
    // static int currx = curr.getX();
    // static int curry = curr.getY();
    static int currx = 0;
    static int curry = 5;
    public static int[][] resetMaze(){
            MazeGenerator1 xx = new MazeGenerator1(30);
            xx.generateMaze();
            for(int i = 0;i<30;i++){
                for(int j = 0;j<30;j++){
                    if(xx.maze[i][j]==0) {xx.maze[i][j]=1;}
                    else if(xx.maze[i][j]==1) {xx.maze[i][j]=0;}
                }
            }
            return xx.maze;
            // return mm.getMaze2();
    }
    public static void main(String[] args) {
            int [][] maze = resetMaze();
            print1(maze);
            // Return curr = mm.getStart();
            // int currx = curr.getX();
            // int curry = curr.getY();
            
            // finalx = 4;
            // finaly = 11;
            System.out.print("Start: ");
            System.out.println(currx + ","+ curry);
            // System.out.print("End: ");
            // System.out.println(finalx + ","+ finaly);
            moveGenerator(currx, curry, maze);
            print1(maze);
            // System.out.println("C"+c);
            // while(true){
                
            // if(c==1){
            //     System.out.println("Success");
            //     print1(maze);
            //     break;
            // }
            // else{
            //     System.out.println("Fail");
            //     print1(maze);
            //     c = moveGenerator(currx, curry, resetMaze());
            // }
        }


        static void print(int[][] arr){
            for(int i = 0;i<mm.getH();i++){
                for(int j = 0;j< mm.getW();j++){
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
        static void print1(int[][] arr){
            for(int i = 0;i<mm.getH();i++){
                for(int j = 0;j<mm.getW();j++){
                    if(arr[i][j]==1  || arr[i][j]==9) System.out.print(" "+" ");
                    else if(arr[i][j]==2) System.out.print("."+" ");
                    else if(arr[i][j]==0) System.out.print("#"+" ");
                    
                }
                // System.out.print("|");
                System.out.println("");
                // System.out.println("-------------------------------------");
            }
            System.out.println("");
        }
        
        static Return up(int x,int y){return new Return(--x, y);}
        static Return down(int x,int y){return new Return(++x, y);}
        static Return left(int x,int y){return new Return(x, --y);}
        static Return right(int x,int y){return new Return(x, ++y);}

        static Return choose(int x,int y,int z){
            switch(z) {
                case 1:
                    Return e = up(x,y);
                    e = (e.getX()>=0 && e.getX()<mm.getH() ? e:new Return(x,y)); 
                    return e;
                case 2:
                    Return e1 = down(x,y);
                    e1 = (e1.getX()>=0 && e1.getX()<mm.getH() ? e1:new Return(x,y)); 
                    return e1;
                case 3:
                    Return e2 = left(x,y);
                    e2 = (e2.getY()>=0 && e2.getY()<mm.getW() ? e2:new Return(x,y)); 
                    return e2;
                case 4:
                    Return e3 = right(x,y);
                    e3 = (e3.getY()>=0 && e3.getY()<mm.getW() ? e3:new Return(x,y)); 
                    return e3;
            }
            return new Return(2,0);

        }
        
        static int  moveGenerator(int x,int y,int [][] maze){
            // Random r = new Random();
            // Return d = choose(currx, curry, 1+ r.nextInt(4));
            // System.out.println(count);
            try{
            // if(x==finalx && y== finaly && mm.checkEnd(x, y)){
            //     maze[x][y] =2;
            //     System.out.println("Success");
            //     return 1;}
            if((x!=currx && y!= curry) && mm.checkEnd(x, y)){
                maze[x][y] =2;
                System.out.println("Success");
                return 1;
            }
            if(count==5) {
                // System.out.println("test");
                Return d = backoff(x, y, maze);
                count = 1;
                moveGenerator(d.getX(), d.getY(), maze);
                return 1;}
            if(maze[x][y]==0 || maze[x][y]==2 || maze[x][y] ==9){
                // System.out.println("test1");
                Return d = choose(x, y,count++);
                // System.out.println(d.getX()+","+d.getY());
                if(maze[d.getX()][d.getY()]==1){
                    count = 1;
                    moveGenerator(d.getX(), d.getY(),maze);}
                else{
                    moveGenerator(x, y,maze);
                }
            }
            else if(maze[x][y]==1){
                // System.out.println("test2");
                maze[x][y] = 2;
                print1(maze);
                count = 1;
                // Return d = choose(x, y, count);
                // System.out.println(d.getX()+","+d.getY());
                moveGenerator(x,y,maze);
            }}
            catch(Exception e){
                print1(maze);
                System.out.println("Failed");
            }

            return 1;
        }
        public static Return backoff(int x,int y,int [][] maze){
            maze[x][y] = 9;
            if(maze[x+1][y]==2){ x = x+1; }
            else if(maze[x-1][y]==2){ x = x-1;}
            else if(maze[x][y-1]==2){y = y-1; }
            else if(maze[x][y+1]==2){ y= y+1;}
            return new Return(x, y);

        }
        
        
    
    }
    

