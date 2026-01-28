package Seokhyeon;

import java.util.*;
import java.io.*;

public class ThrowStone {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case < T+1; test_case++){
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] power = new int[num];
            for(int i=0; i<num; i++){
                int temp = Integer.parseInt(st.nextToken());
                power[i] = temp;
                // power[i] = Interger.parseInt(st.nextToken());
            }
            int[][] coor = new int[num][2];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<num; i++){
                coor[i][0] = Integer.parseInt(st.nextToken()) - 1;
                coor[i][1] = Integer.parseInt(st.nextToken()) - 1;
            }
            int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
            int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
            for(int i=0; i<num; i++){
                int cur_x = coor[i][0];
                int cur_y = coor[i][1];
                map[cur_y][cur_x] += 1;
                int range = power[i];
                for(int j=1; j<=range; j++){
                    for(int k=0; k<dx.length; k++){
                        int x = cur_x+j*dx[k];
                        int y = cur_y+j*dy[k];
                        if(x>=0 && x<n && y>=0 && y<n){
                            map[cur_y+j*dy[k]][cur_x+j*dx[k]] += 1;
                        }
                    }
                }
            }
            int max = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(max < map[i][j]){
                        max = map[i][j];
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(max);
            System.out.println(sb);
        }
    }
}