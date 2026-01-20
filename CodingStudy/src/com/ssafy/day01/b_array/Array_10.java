package com.ssafy.day01.b_array;

public class Array_10 {
    private static int R = 4, C = 5;
    private static char[][] map;
    private static StringBuilder output1 = new StringBuilder();
    private static StringBuilder output2 = new StringBuilder();
    private static StringBuilder output3 = new StringBuilder();
    private static StringBuilder output4 = new StringBuilder();

    private static void setup() {
        map = new char[R][C];
        // TODO: 위 배열을 알파벳 대문자 A ~ T로 초기화 하시오.
        int a = 1;
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		map[i][j] = (char) (64 + a);
        		a++;
        	}
        }
        // END
    }

    public static void main(String[] args) {
        setup();
        //rowFirst();
        //colFirst();
        //zigzag();
       snail();
    }

    private static void rowFirst() {
        // TODO: 행우선 탐색을 작성하시오.
        for(int i=0; i<R; i++) {
	    	for(int j=0; j<C; j++) {
	    		output1.append(map[i][j]);
	    	}
        }
        // END
        System.out.println(output1.toString().equals("ABCDEFGHIJKLMNOPQRST"));
    }

    private static void colFirst() {
        // TODO: 열우선 탐색을 작성하시오.
    	for(int i=0; i<C; i++) {
    		for(int j=0; j<R; j++) {
    			output2.append(map[j][i]);
    		}
    	}
        // END
        System.out.println(output2.toString().equals("AFKPBGLQCHMRDINSEJOT"));
    }

    private static void zigzag() {
        // TODO: zigzag 탐색을 작성하시오.
    	for(int i=0; i<R; i++) {
    		for(int j=0; j<C; j++) {
    			if(i%2==0) {
    				output3.append(map[i][j]);
    			} else {
    				output3.append(map[i][C-j-1]);
    			}
    		}
    	}
        // END
        System.out.println(output3.toString().equals("ABCDEJIHGFKLMNOTSRQP"));
    }

    private static void snail() {
     // TODO: 달팽이 탐색을 작성하시오.
    	int[] dx = {0, 1, 0, -1}; 
    	int[] dy = {1, 0, -1, 0};
        int x =0, y =0;
        int dir = 0;
        
        boolean[][] vis = new boolean[R][C];
        
        for(int i=0; i<R*C; i++) {
        	output4.append(map[x][y]);
        	vis[x][y] = true;
        	  int nx = x + dx[dir];
        	  int ny = y + dy[dir];
        	  if(nx <0 || nx >=R || ny<0 || ny>=C || vis[nx][ny]) {
        		  dir = (dir+1)%4;
        		  nx = x + dx[dir];
        		  ny = y + dy[dir];
        	  }
        	  x = nx;
        	  y = ny;
        	 // System.out.print(map[i][j]);
        }
        
       
        
        // END
        System.out.println(output4.toString().equals("ABCDEJOTSRQPKFGHINML"));
    }

    private static boolean isIn(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }

}
